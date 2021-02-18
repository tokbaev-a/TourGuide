package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter  extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Nature";
        } else if (position == 1) {
            return "Spirit";
        }else {
            return "Food";
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NatureFragment();
        } else if (position == 1) {
            return new TempleFragment();
        }else {
            return new FoodFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}



