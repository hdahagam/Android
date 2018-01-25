package com.example.hdahagam.app10;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hdahagam on 11/16/2017.
 */

    public class WelcomePageAdapter extends PagerAdapter {

        private int[] layouts;
        private LayoutInflater Inflater;
        private Context mcontext;

        public WelcomePageAdapter(int[] layouts, Context context ){
            this.layouts = layouts;
            this.mcontext = context;
            Inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }



        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View vw, Object obj) {
            return vw==obj;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int pos) {
            View vw = Inflater.inflate(layouts[pos],container,false);
            container.addView(vw);
            return vw;
        }

        @Override
        public void destroyItem(ViewGroup container, int pos, Object obj) {
            View vw = (View)obj;
            container.removeView(vw);
        }
    }