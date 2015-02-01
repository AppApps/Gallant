package io.blasto.gallant;

import android.graphics.Color;

/**
 * Created by Blasto on 12/17/2014.
 */
public class GlobalHelper {
    private int globalDynamicColor = Color.parseColor("#009688");

    public int getGlobalDynamicColor() {
        return globalDynamicColor;
    }

    public void setGlobalDynamicColor(int color) {
        globalDynamicColor = color;
    }
}
