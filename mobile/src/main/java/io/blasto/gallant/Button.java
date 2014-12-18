package io.blasto.gallant;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Button extends RelativeLayout {

    public boolean isLastTouch = false;
    int minWidth;
    int minHeight;
    float rippleSpeed = 10f;
    int rippleSize = 3;
    OnClickListener onClickListener;
    int background = MainActivity.globalBackgroundColor.getGlobalDynamicColor();


    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDefaultProperties();
    }

    protected void setDefaultProperties() {
        setMinimumHeight(dpToPx(minHeight, getResources()));
        setMinimumWidth(dpToPx(minWidth, getResources()));
        setBackgroundResource(background);
    }

    public int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }
    // Set atributtes of XML to View


    // ### RIPPLE EFFECT ###

    float x = -1, y = -1;
    float radius = -1;

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        isLastTouch = true;
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            radius = getHeight() / rippleSize;
            x = event.getX();
            y = event.getY();

//            View mTabStrip = SlidingTabStrip.;
//            tabView = LayoutInflater.from(getContext()).inflate(R.layout.page, SlidingTabStrip,
//                    false);
//            mTabStrip.addView(tabView);
//            if (i == mViewPager.getCurrentItem()) {
//                tabView.setSelected(true);
//            }
//
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            radius = getHeight() / rippleSize;
            x = event.getX();
            y = event.getY();
            if (!((event.getX() <= getWidth() && event.getX() >= 0) &&
                    (event.getY() <= getHeight() && event.getY() >= 0))) {
                isLastTouch = false;
                x = -1;
                y = -1;
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if ((event.getX() <= getWidth() && event.getX() >= 0) &&
                    (event.getY() <= getHeight() && event.getY() >= 0)) {
                radius++;
            } else {
                isLastTouch = false;
                x = -1;
                y = -1;
            }
        }
        return true;
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction,
                                  Rect previouslyFocusedRect) {
        if (!gainFocus) {
            x = -1;
            y = -1;
        }
    }

    public Bitmap makeCircle() {
        Bitmap output = Bitmap.createBitmap(getWidth() - dpToPx(6, getResources()),
                getHeight() - dpToPx(7, getResources()), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawColor(MainActivity.globalBackgroundColor.getGlobalDynamicColor());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(makePressColor());
        canvas.drawCircle(x, y, radius, paint);
        if (radius > getHeight() / rippleSize)
            radius += rippleSpeed;
        if (radius >= getWidth()) {
            x = -1;
            y = -1;
            radius = getHeight() / rippleSize;
            if (onClickListener != null)
                onClickListener.onClick(this);
        }
        return output;
    }

    /**
     * Ripple effect has a darker color.
     */
    protected int makePressColor() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int [] rgb = {16, 8, 0};
        int count = 0;

        for(int x : rgb ){
            int integer = (MainActivity.globalBackgroundColor.getGlobalDynamicColor() >> x) & 0xFF;
            map.put(count, (integer - 30 < 0) ? 0 : integer - 30);
            count ++;
        }

        return Color.rgb(map.get(0), map.get(1), map.get(2));
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        onClickListener = l;
    }

    // Set color of background
    public void setBackgroundColor(int color) {
        LayerDrawable layer = (LayerDrawable) getBackground();
        GradientDrawable shape = (GradientDrawable) layer.findDrawableByLayerId(R.id.shape_background);
        shape.setColor(MainActivity.globalBackgroundColor.getGlobalDynamicColor());
    }
}
