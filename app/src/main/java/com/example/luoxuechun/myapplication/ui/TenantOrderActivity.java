package com.example.luoxuechun.myapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.luoxuechun.myapplication.R;

/**
 * Created by luoxuechun on 2017/6/3.
 */



public class TenantOrderActivity extends Activity {

    private ListView orderList;
    private Button startOrder;
    private Button checkDateButton;
    private Button localButton;
    private Button priceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_order);

        startOrder=(Button)findViewById(R.id.startOrderButton);
        checkDateButton=(Button)findViewById(R.id.checkDateButton);
        localButton=(Button)findViewById(R.id.localButton);
        priceButton=(Button)findViewById(R.id.priceButton);







    }
}
