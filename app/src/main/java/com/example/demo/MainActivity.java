package com.example.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.demo.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list = new ArrayList<>();
    //当前所显示的条目
    private int zongNum = 0;
    //当前所显示条目数一半，也就是所显示的中间位置占几个条目
    private int middleNum = 0;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);

        myAdapter = new MyAdapter(MainActivity.this, list);

        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //改变背景
                myAdapter.changeSelectBackground(i);
                // 得到当前显示条目
                int childCount = adapterView.getChildCount();

                if (zongNum == 0) {
                    zongNum = childCount;
                    if (zongNum != list.size()) {
                        middleNum = zongNum / 2;
                    }
                }


                if (i <= (adapterView.getFirstVisiblePosition() + middleNum)) {
                    //如果点击条目高于 此列表的正中 则 列表整体上移
                    listView.smoothScrollToPosition(i + 1 - middleNum);

                } else {

                    //如果点击条目低于 此列表的正中 则 列表整体下移
                    listView.smoothScrollToPosition(i - 1 + middleNum);
                }
            }
        });

    }
}
