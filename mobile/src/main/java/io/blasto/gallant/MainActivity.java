package io.blasto.gallant;

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
import android.widget.ListView;

import java.util.LinkedHashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    public static GlobalHelper globalBackgroundColor = new GlobalHelper();

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    ViewPager pager;
    private String titles[] = new String[]{"Sample Tab 1", "Sample Tab 2", "Sample Tab 3", "Sample Tab 4"
            , "Sample Tab 5", "Sample Tab 6", "Sample Tab 7", "Sample Tab 8"};
    private Toolbar toolbar;

    SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView mDrawerList = (ListView) findViewById(R.id.navdrawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }
        pager = (ViewPager) findViewById(R.id.viewpager);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), titles));

        slidingTabLayout.setViewPager(pager);
        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.WHITE;
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);
        String[] values = new String[]{
                "RED", "PINK", "PURPLE", "DEEP PURPLE", "INDIGO", "BLUE", "LIGHT BLUE", "CYAN", "TEAL", "GREEN", "LIGHT GREEN", "LIME", "YELLOW", "AMBER", "ORANGE", "DEEP_ORANGE", "BROWN", "GREY", "BLUE GREY"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Map<Integer, Integer> map = new LinkedHashMap<>();
                map.put(0,R.color.red_500);
                map.put(1,R.color.pink_500);
                map.put(2,R.color.purple_500);
                map.put(3,R.color.deep_purple_500);
                map.put(4,R.color.indigo_500);
                map.put(5,R.color.blue_500);
                map.put(6,R.color.light_blue_500);
                map.put(7,R.color.cyan_500);
                map.put(8,R.color.teal_500);
                map.put(9,R.color.green_500);
                map.put(10,R.color.light_green_500);
                map.put(11,R.color.lime_500);
                map.put(12,R.color.yellow_500);
                map.put(13,R.color.amber_500);
                map.put(14,R.color.orange_500);
                map.put(15,R.color.deep_orange_500);
                map.put(16,R.color.brown_500);
                map.put(17,R.color.grey_500);
                map.put(18,R.color.blue_grey_500);

                // final int newBackgroundColor = map.get(position);

                globalBackgroundColor.setGlobalDynamicColor(getResources().getColor(map.get(position)));

                toolbar.setBackgroundColor(globalBackgroundColor.getGlobalDynamicColor());
                slidingTabLayout.setBackgroundColor(globalBackgroundColor.getGlobalDynamicColor());
                ProgressBarCircular progressBarCircular = (ProgressBarCircular) findViewById(R.id.progress);
                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabButton);
                fab.setBackgroundColor(globalBackgroundColor.getGlobalDynamicColor());
                progressBarCircular.setBackgroundColor(globalBackgroundColor.getGlobalDynamicColor());
                mDrawerLayout.closeDrawer(Gravity.START);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            mDrawerLayout.closeDrawer(Gravity.START);
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
