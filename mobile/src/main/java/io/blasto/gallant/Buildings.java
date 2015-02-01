package io.blasto.gallant;

/**
 * Created by Blasto on 1/31/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ViewAnimator;

import java.util.LinkedHashMap;
import java.util.Map;

import io.blasto.gallant.FloatingActionButton;
import io.blasto.gallant.GlobalHelper;
import io.blasto.gallant.ProgressBarCircular;
import io.blasto.gallant.R;
import io.blasto.gallant.ViewPagerAdapter;
import io.blasto.gallant.view.SlidingTabLayout;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.view.LayoutInflater;
import android.support.v4.app.ListFragment;
import android.app.Activity;

import io.blasto.gallant.activities.MainActivity;


public class Buildings extends ListFragment {
    private static final String ARG_POSITION = "position";

    public static Buildings newInstance(int position) {
        Buildings f = new Buildings();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
//        View rootView = inflater.inflate(R.layout.buildings_list, container, false);
//
//        final ListView mDrawerList = (ListView) rootView.findViewById(R.id.buildings_list_test);

        String[] values = new String[]{
                "RED",
                "PINK",
                "PURPLE",
                "DEEP PURPLE",
                "INDIGO",
                "BLUE",
                "LIGHT BLUE",
                "CYAN",
                "TEAL",
                "GREEN",
                "LIGHT GREEN",
                "LIME",
                "YELLOW",
                "AMBER",
                "ORANGE",
                "DEEP ORANGE",
                "BROWN",
                "GREY",
                "BLUE GREY"
        };

//        Map<Integer, String> map = new LinkedHashMap<>();
//        map.put(0,"test1");
//        map.put(1,"test2");
//        map.put(2,"test3");
//        map.put(4,"test4");
//        map.put(5,"test5");
//        map.put(6,"test6");
//        map.put(7,"test7");
//        map.put(8,"test8");
//        map.put(9,"test9");
//        map.put(10,"test10");
//        map.put(11,"test11");
//        map.put(12,"test12");
//        map.put(13,"test13");
//        map.put(14,"test14");
//        map.put(15,"test15");
//        map.put(16,"test16");
//        map.put(17,"test17");
//        map.put(18,"test18");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_buildings, values);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println(id);

    }
}