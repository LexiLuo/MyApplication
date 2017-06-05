package com.example.luoxuechun.myapplication.ui;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.luoxuechun.myapplication.R;

/**
 * Created by luoxuechun on 2017/6/5.
 */
public class OrderResultsItemActivity extends Activity {

    private TextView originPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_results_item);

        originPrice=(TextView)findViewById(R.id.originPrice);
        originPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
