package com.hk.suisafe;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    Context mContext;

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return FragmentB.newInstance(0);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FragmentC.newInstance(1);
            case 2: // Fragment # 1 - This will show SecondFragment
                return FragmentA.newInstance(2);
            case 3:
                return FragmentD.newInstance(3);
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle ( int position){
        // Generate title based on item position
        String tabTitles[] = new String[]{mContext.getString(R.string.plan), mContext.getString(R.string.guide), mContext.getString(R.string.crisis),"Depression"};
        return tabTitles[position];
    }
}
