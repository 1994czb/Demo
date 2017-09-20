package com.example.demo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<String> list = new ArrayList<>();
    private int selectId;


    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        for (int i = 0; i < 50; i++) {
            list.add("商品"+i);
        }
    }

    //改变背景方法
    public void changeSelectBackground(int pos){

        this.selectId = pos;

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder =null;
        if (view==null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item,null);
            holder.name=view.findViewById(R.id.name);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.name.setText(list.get(i));


        /**
         * 如果点击的是此条目 则改变背景
         */
        if(i == selectId){
            holder.name.setTextColor(Color.parseColor("#FFE13F5A"));
            view.setBackgroundColor(Color.parseColor("#d9d8dd"));
        }else {
            holder.name.setTextColor(Color.parseColor("#000000"));
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        return view;
    }
    class ViewHolder{
        TextView name;
    }
}
