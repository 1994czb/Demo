package com.example.numcasedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.numcasedemo.adapter.MyAdapter;
import com.example.numcasedemo.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<DataBean> list;
    private MyAdapter adapter;

    private ImageView toTopImg;  //回到顶部的按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rec);
        toTopImg = (ImageView) findViewById(R.id.toTop);

        //添加数据
        initData();

        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter = new MyAdapter(list,this);


        mRecyclerView.setAdapter(adapter);


        //滑动监听
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //得到此RecyclerView的布局信息
                RecyclerView.LayoutManager layoutManager = recyclerView
                        .getLayoutManager();

                //判断属于什么布局
                if(layoutManager instanceof GridLayoutManager){

                    //得到布局信息中 第一条可见条目的位置
                    int firstItem = ((LinearLayoutManager) layoutManager)
                            .findFirstVisibleItemPosition();

                    if(firstItem > 10){

                        toTopImg.setVisibility(View.VISIBLE);

                        toTopImg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                //回到顶部
                                recyclerView.scrollToPosition(0);
                            }
                        });

                    }else {
                        toTopImg.setVisibility(View.GONE);

                    }

                }else if(layoutManager instanceof LinearLayoutManager){
                    int firstItem = ((LinearLayoutManager) layoutManager)
                            .findFirstVisibleItemPosition();

                    if(firstItem > 5){

                        toTopImg.setVisibility(View.VISIBLE);

                        toTopImg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                recyclerView.scrollToPosition(0);
                            }
                        });

                    }else {
                        toTopImg.setVisibility(View.GONE);

                    }
                }

            }
        });

    }

    private void initData() {
        list = new ArrayList<>();

        list.add(new DataBean(2000,35));
        list.add(new DataBean(12334,335));
        list.add(new DataBean(200,325));
        list.add(new DataBean(5400,352));
        list.add(new DataBean(8500,15));
        list.add(new DataBean(6399,42));
        list.add(new DataBean(7430,565));
        list.add(new DataBean(9100,353));
        list.add(new DataBean(3000,251));
        list.add(new DataBean(2460,167));
        list.add(new DataBean(7822,336));
        list.add(new DataBean(2100,35));
        list.add(new DataBean(2050,35));
        list.add(new DataBean(2077,35));
        list.add(new DataBean(1900,3335));
        list.add(new DataBean(11000,165));
        list.add(new DataBean(50,152));
        list.add(new DataBean(210,155));
        list.add(new DataBean(2000,35));
        list.add(new DataBean(13004,335));
        list.add(new DataBean(154,125));
        list.add(new DataBean(1444,222));
        list.add(new DataBean(3100,134));
        list.add(new DataBean(69,425));
        list.add(new DataBean(4030,235));
        list.add(new DataBean(1200,33));
        list.add(new DataBean(3660,121));
        list.add(new DataBean(1260,1367));
        list.add(new DataBean(922,396));
        list.add(new DataBean(8800,535));
        list.add(new DataBean(8190,45));
        list.add(new DataBean(277,66));
        list.add(new DataBean(660,331));
        list.add(new DataBean(6660,265));
        list.add(new DataBean(53,132));
        list.add(new DataBean(690,135));


    }

    //按钮点击事件，按价格排序
    public void sortByPrice(View view) {


        adapter.sortByPrice();

    }

    //按钮点击事件，按销量排序
    public void sortBySales(View view) {

        adapter.sortBySales();

    }


}
