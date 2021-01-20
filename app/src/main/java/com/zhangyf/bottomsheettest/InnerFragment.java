package com.zhangyf.bottomsheettest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class InnerFragment extends Fragment {


    RecyclerView rvInner;

    InnerRecyclerViewAdapter innerRecyclerViewAdapter;

    String type;

    private List<String> list = new ArrayList<>();

    private MyViewPagerBottomSheetBehavior behavior;

    public void setBehavior(MyViewPagerBottomSheetBehavior behavior) {
        this.behavior = behavior;
    }

    public InnerFragment(String type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inner, container, false);
        rvInner = view.findViewById(R.id.rv_inner);

        initListView();

        return view;
    }

    private void initListView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        rvInner.setLayoutManager(gridLayoutManager);
        innerRecyclerViewAdapter = new InnerRecyclerViewAdapter(getContext());
        /*HorizontalItemDecoration horizontalItemDecoration = new HorizontalItemDecoration(DeviceUtil.dp2px(getActivity(), 7));
        rvInner.addItemDecoration(horizontalItemDecoration);*/
        rvInner.setAdapter(innerRecyclerViewAdapter);

        /*behavior.isScrollViewOnTopMap.put(0,false);
        behavior.isScrollViewOnTopMap.put(1,false);*/

        //滑动监听
        rvInner.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                /*if (behavior != null) {
                    Log.d("!!!!!!!!!", String.valueOf(!recyclerView.canScrollVertically(-1)) + dy);
                    if (dy == 0) {
                        //指尖未真实上下滑动（针对从viewpager其他页面切换过来时），不做任何操作
                        return;
                    }
                    if (!recyclerView.canScrollVertically(-1) && dy < 0) {
                        //不可以下拉，并且手势是下拉，通知behavior已经列表已经在顶部了
                        Log.d("~~~~~", "划不动了");
                        behavior.setCurrentScrollViewOnTop(true);
                    } else {
                        //可以下拉或者手势不是下拉，通知behavior已经列表不在顶部
                        behavior.setCurrentScrollViewOnTop(false);
                    }
                }*/
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                /*if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    behavior.setScrollViewOnTop(false);
                }*/
            }
        });


        testData();
    }

    private void testData() {
        for (int i = 0; i < 50; i++) {
            list.add(i + "");
        }
        innerRecyclerViewAdapter.setData(list);
    }

}
