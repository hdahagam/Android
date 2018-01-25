package com.example.hdahagam.app3;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Locale;

public class ViewPageActivity extends AppCompatActivity {
    ViewPager viewPage;
    movie_data md;
    MyFragmentPageAdapter myStateFragmentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        md = new movie_data();
        myStateFragmentPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(),md.getSize());
        viewPage = (ViewPager) findViewById(R.id.viewpager);
        viewPage.setAdapter(myStateFragmentPageAdapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabBar);
        tabLayout.setupWithViewPager(viewPage);
    }
    public class MyFragmentPageAdapter extends FragmentPagerAdapter {
        int count;

        public MyFragmentPageAdapter(FragmentManager fm, int size){
            super(fm);
            count = size;
        }

        @Override
        public Fragment getItem(int position){
            return movieDataFragment.newInstance((HashMap<String, ?>)md.getItem(position));
        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public CharSequence getPageTitle(int position){
            Locale l = Locale.getDefault();
            HashMap<String, ?> movie = (HashMap<String, ?>) md.getItem(position);
            String name = (String) movie.get("title");
            return name.toUpperCase(l);
        }
    }
}
