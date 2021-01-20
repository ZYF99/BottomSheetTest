package com.zhangyf.bottomsheettest;

import android.os.Bundle;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Pair<InnerFragment, String>> fragmentList;

    public MyPagerAdapter(@NonNull FragmentManager fm, List<Pair<InnerFragment, String>> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("type",fragmentList.get(position).second);
        fragmentList.get(position).first.setArguments(bundle);
        return fragmentList.get(position).first;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).second;
    }
}