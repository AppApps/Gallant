package io.blasto.gallant;

/**
 * Created by Blasto on 1/31/15.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.blasto.gallant.activities.MainActivity;


public class Weapons extends Fragment {
    private static final String ARG_POSITION = "position";

    public static Weapons newInstance(int position) {
        Weapons f = new Weapons();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_weapons, container, false);

//        ProgressBarCircular progressBarCircular = (ProgressBarCircular) rootView.findViewById(R.id.progress);
//        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabButton);
//        fab.setDrawableIcon(getResources().getDrawable(R.drawable.plus));
//        fab.setBackgroundColor(MainActivity.globalBackgroundColor.getGlobalDynamicColor());
//        progressBarCircular.setBackgroundColor(MainActivity.globalBackgroundColor.getGlobalDynamicColor());
//        TextView weapons_test = (TextView) rootView.findViewById(R.id.weapons_test);
//        weapons_test.setText("Meow meow meow");

        return rootView;
    }
}