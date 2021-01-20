package com.zhangyf.bottomsheettest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout fl_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_container = findViewById(R.id.fl_container);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment(MyViewPagerBottomSheetBehavior.from(fl_container));
        fragmentTransaction.add(R.id.fl_container, bottomSheetFragment, "aaFragment").commit();


    }
}