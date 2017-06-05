package com.example.luoxuechun.myapplication.ui;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luoxuechun.myapplication.R;

import java.util.ArrayList;

/**
 * Created by luoxuechun on 2017/6/5.
 */
public class RoomResultsDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private HomeAdapter mAdapter;
    private TextView originPrice2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_results_detail);
        initData();
        mRecyclerView=(RecyclerView)findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(this);
        linearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManagerHorizontal);
        mRecyclerView.addItemDecoration(new RecyclerDivider(getResources().getColor(R.color.colorDivider), 50, 2));
        mRecyclerView.setAdapter(mAdapter= new HomeAdapter());
        originPrice2=(TextView) findViewById(R.id.originText2);
        originPrice2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        mDatas.add("Origin Pirce 260$");
        mDatas.add("First Negotation 256$");
        mDatas.add("Current Price 250$");
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RoomResultsDetailActivity.this).inflate(R.layout.recycle_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;

            public MyViewHolder(View view)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.textView3);
            }
        }
    }
}
