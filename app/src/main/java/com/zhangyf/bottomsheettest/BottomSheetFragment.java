package com.zhangyf.bottomsheettest;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetFragment extends Fragment {

    private MyViewPagerBottomSheetBehavior behavior;

    private List<Pair<InnerFragment, String>> fragmentList = new ArrayList<>();

    TabLayout tabLayout;
    ViewPager vpBottomSheet;

    public BottomSheetFragment(MyViewPagerBottomSheetBehavior behavior) {
        this.behavior = behavior;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);
        vpBottomSheet = view.findViewById(R.id.vp_collection);

        //BottomSheetUtils.setupViewPager(vpBottomSheet);

        InnerFragment innerFragment1 = new InnerFragment("第一个");
        InnerFragment innerFragment2 = new InnerFragment("第二个");

        innerFragment1.setBehavior(behavior);
        innerFragment2.setBehavior(behavior);

        fragmentList.add(Pair.create(innerFragment1, "第一个"));
        fragmentList.add(Pair.create(innerFragment2, "第二个"));

        MyPagerAdapter filmPagerAdapter = new MyPagerAdapter(getChildFragmentManager(), fragmentList);

        tabLayout.setupWithViewPager(vpBottomSheet);
        vpBottomSheet.setAdapter(filmPagerAdapter);
        vpBottomSheet.setOffscreenPageLimit(1);

        //BottomSheetUtils.setupViewPager(binding.vpCollection);

        showSheetDialog();

        return view;
    }

    private void showSheetDialog() {
        behavior.setState(MyViewPagerBottomSheetBehavior.STATE_COLLAPSED);

        behavior.setPeekHeight(this.getResources().getDisplayMetrics().heightPixels / 2 + 50);
        behavior.setHideable(true);

        behavior.setBottomSheetCallback(new MyViewPagerBottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                if (newState == MyViewPagerBottomSheetBehavior.STATE_HIDDEN) {
                    behavior.setState(MyViewPagerBottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

}
