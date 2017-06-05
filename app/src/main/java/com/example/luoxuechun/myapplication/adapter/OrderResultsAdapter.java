package com.example.luoxuechun.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.luoxuechun.myapplication.entity.OrderResultsEntity;

import java.util.LinkedList;

/**
 * Created by luoxuechun on 2017/6/5.
 */

/**
 * 系统反馈订单结果列表的adapter
 */

public class OrderResultsAdapter extends BaseAdapter {

    private LinkedList<OrderResultsEntity> mData;
    private Context mContext;

    public OrderResultsAdapter(LinkedList<OrderResultsEntity> mData,Context mContext){
        this.mData=mData;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
