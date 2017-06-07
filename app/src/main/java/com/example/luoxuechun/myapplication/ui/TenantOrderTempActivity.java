package com.example.luoxuechun.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.example.luoxuechun.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcy on 2017/6/7.
 *
 */

public class TenantOrderTempActivity extends AppCompatActivity{

    private EditText checkinTime, checkoutTime, location;
    private SeekBar price;
    private NumberPicker num;
    private Spinner roomType;
    private CheckBox choose1,choose2,choose3,choose4;
    private List<CheckBox> extra;
    private Button confirm;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tenant_order_temp);

        checkinTime = (EditText)findViewById(R.id.checkin_time);
        checkoutTime = (EditText)findViewById(R.id.checkout_time);
        location = (EditText)findViewById(R.id.location);
        price = (SeekBar)findViewById(R.id.price_seekBar);
        num = (NumberPicker)findViewById(R.id.number_of_room);
        roomType = (Spinner)findViewById(R.id.type_of_room);
        choose1 = (CheckBox)findViewById(R.id.checkBox);
        choose2 = (CheckBox)findViewById(R.id.checkBox2);
        choose3 = (CheckBox)findViewById(R.id.checkBox3);
        choose4 = (CheckBox)findViewById(R.id.checkBox4);
        confirm = (Button)findViewById(R.id.confirm_order);
        extra = new ArrayList<>();
        extra.add(choose1);
        extra.add(choose2);
        extra.add(choose3);
        extra.add(choose4);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                String inTime = checkinTime.getText().toString();
                String outTime = checkoutTime.getText().toString();
                String loca = location.getText().toString();
                String pri = String.valueOf(price.getProgress());
                String n = num.getValue()+"";
                String type = roomType.getSelectedItem()+"";
                StringBuilder extra_requirements = new StringBuilder();
                for(CheckBox cb:extra){
                    if(cb.isChecked()){
                        extra_requirements.append(cb.getText().toString()+" ");
                    }
                }

                Bundle data = new Bundle();
                data.putString("checkinTime",inTime);
                data.putString("checkoutTime",outTime);
                data.putString("location",loca);
                data.putString("price",pri);
                data.putString("number",n);
                data.putString("type",type);
                data.putString("extra_requirements",extra_requirements.toString());

                Intent it = new Intent();
                it.putExtras(data);
            }
        });

    }
}
