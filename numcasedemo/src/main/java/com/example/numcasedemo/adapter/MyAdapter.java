package com.example.numcasedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.numcasedemo.R;
import com.example.numcasedemo.bean.DataBean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<DataBean> list, Context context) {
        this.list = list;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(
                inflater.inflate(R.layout.item_numcase, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.price.setText(list.get(position).getPrice() + "价格");
        holder.sales.setText(list.get(position).getSales() + "销量");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView price;
        TextView sales;

        public MyViewHolder(View itemView) {
            super(itemView);

            price = (TextView) itemView.findViewById(R.id.tv_price);
            sales = (TextView) itemView.findViewById(R.id.tv_sales);
        }
    }




    public void sortByPrice() {

        //排序方法
        Collections.sort(list, new Comparator<DataBean>() {
            @Override
            public int compare(DataBean o1, DataBean o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });

        notifyDataSetChanged();

    }
    //
    public void sortBySales() {

        Collections.sort(list, new Comparator<DataBean>() {
            @Override
            public int compare(DataBean o1, DataBean o2) {
                return o2.getSales() - o1.getSales();
            }
        });

        notifyDataSetChanged();

    }
}

