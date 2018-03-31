package com.example.tcsexam.trainingday3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by TCSExam on 3/31/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragment = new ArrayList<>();
    ArrayList<String> tabTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(Fragment fragment, String titles){
        this.fragment.add(fragment);
        this.tabTitle.add(titles);
    }

    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }
}
