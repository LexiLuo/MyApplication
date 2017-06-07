package com.example.luoxuechun.myapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luoxuechun.myapplication.R;
import com.example.luoxuechun.myapplication.adapter.OrderResultsAdapter;
import com.example.luoxuechun.myapplication.entity.OrderResultsEntity;

import java.util.ArrayList;

/**
 * Created by luoxuechun on 2017/6/5.
 */
public class OrderResultsActivity extends BaseAppCompatActivity  implements AdapterView.OnItemClickListener{

    private ListView mListView;

    private ArrayList<OrderResultsEntity> mList;

    @Override
    public void onCreate(Bundle savedInstanceState){
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_order_results);
        setToolBarTitle("Order Results");

        mListView=(ListView)findViewById(R.id.listView);
        Resources res=this.getResources();
        mList=new ArrayList<OrderResultsEntity>();

        //初始化data
        ArrayList<String> tags=new ArrayList<>();
        OrderResultsEntity orderResultsEntity1=new OrderResultsEntity(255,230,"0.19km away from the destination","Lingnanjiayuan Chain Hotel",4.62,tags);
        OrderResultsEntity orderResultsEntity2=new OrderResultsEntity(250,235,"0.31km away from the destination","Jiaxin Hotel",4.66,tags);
        OrderResultsEntity orderResultsEntity3=new OrderResultsEntity(180,160,"0.22km away from the destination","Jiayu Hotel",4.71,tags);
        OrderResultsEntity orderResultsEntity4=new OrderResultsEntity(198,162,"0.28km away from the destination","Inn De Hotel",4.74,tags);
        OrderResultsEntity orderResultsEntity5=new OrderResultsEntity(260,240,"0.38km away from the destination","Wong Kim Dinh Hotel",4.61,tags);

        mList.add(orderResultsEntity4);
        mList.add(orderResultsEntity3);
        mList.add(orderResultsEntity2);
        mList.add(orderResultsEntity1);
        mList.add(orderResultsEntity5);

        OrderResultsAdapter orderResultsAdapter=new OrderResultsAdapter(mList,OrderResultsActivity.this);
        mListView.setAdapter(orderResultsAdapter);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_results;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
       //if(mList.get(position).equals("Button")){
        Toast.makeText(OrderResultsActivity.this,"你点击了第" + position + "项",Toast.LENGTH_SHORT).show();
           Intent intent=new Intent();
           intent.setClass(OrderResultsActivity.this,RoomResultsDetailActivity.class);
           startActivity(intent);

           //intent.putExtra("hotelName",originPrice.getText());
       //}

       // intent.putExtra("hotelName",);

    }

}
