package com.example.luoxuechun.myapplication.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luoxuechun.myapplication.R;
import com.example.luoxuechun.myapplication.entity.OrderResultsEntity;
import com.example.luoxuechun.myapplication.ui.OrderResultsActivity;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by luoxuechun on 2017/6/5.
 */

/**
 * 系统反馈订单结果列表的adapter
 */

public class OrderResultsAdapter extends BaseAdapter {

    private ArrayList<OrderResultsEntity> mData;
    private Context mContext;

    public OrderResultsAdapter(ArrayList<OrderResultsEntity> mData,Context mContext){
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
          if(convertView == null){
              convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_order_results_item,parent,false);
          }


        TextView originPrice=(TextView)convertView.findViewById(R.id.originPrice);
        originPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        originPrice.setText(mData.get(position).getOriginPrice()+"");
        TextView currentPrice=(TextView)convertView.findViewById(R.id.currentPrice);
        currentPrice.setText(mData.get(position).getCurrentPrice()+"");
        TextView hotelName=(TextView) convertView.findViewById(R.id.hotelNameText);
        hotelName.setText(mData.get(position).getName());
        TextView hotelLocation=(TextView) convertView.findViewById(R.id.hotelLocationText);
        hotelLocation.setText(mData.get(position).getLocation());
        Button orderNowButton=(Button)convertView.findViewById(R.id.orderNowButton);
        Button decideButton=(Button)convertView.findViewById(R.id.decideButton);


//        img_icon.setBackgroundResource(mData.get(position).getaIcon());
//        txt_aName.setText(mData.get(position).getaName());
//        txt_aSpeak.setText(mData.get(position).getaSpeak());
        return convertView;
   }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ListItemView listItemView;
//
//        // 初始化item view
//        if (convertView == null) {
//            // 通过LayoutInflater将xml中定义的视图实例化到一个View中
//            convertView = LayoutInflater.from(OrderResultsActivity.this).inflate(
//                    R.layout.activity_order_results_item, null);
//
//            // 实例化一个封装类ListItemView，并实例化它的两个域
//            listItemView = new ListItemView();
//            listItemView.imageView = (ImageView) convertView
//                    .findViewById(R.id.image);
//            listItemView.textView = (TextView) convertView
//                    .findViewById(R.id.title);
//
//            // 将ListItemView对象传递给convertView
//            convertView.setTag(listItemView);
//        } else {
//            // 从converView中获取ListItemView对象
//            listItemView = (ListItemView) convertView.getTag();
//        }
//
//        // 获取到mList中指定索引位置的资源
//        Drawable img = mList.get(position).getImage();
//        String title = mList.get(position).getTitle();
//
//        // 将资源传递给ListItemView的两个域对象
//        listItemView.imageView.setImageDrawable(img);
//        listItemView.textView.setText(title);
//
//        // 返回convertView对象
//        return convertView;
//    }


}
