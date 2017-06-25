package com.example.luoxuechun.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
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

public class TenantOrderTempActivity extends BaseAppCompatActivity{

    private EditText checkinTime, checkoutTime, location;
    private SeekBar price;
    private Spinner roomType;
    private CheckBox choose1,choose2,choose3,choose4;
    private List<CheckBox> extra;
    private Button confirm;

    //手指上下滑动时的最小速度
    private static final int YSPEED_MIN = 1000;

    //手指向右滑动时的最小距离
    private static final int XDISTANCE_MIN = 150;

    //手指向上滑或下滑时的最小距离
    private static final int YDISTANCE_MIN = 100;

    //记录手指按下时的横坐标。
    private float xDown;

    //记录手指按下时的纵坐标。
    private float yDown;

    //记录手指移动时的横坐标。
    private float xMove;

    //记录手指移动时的纵坐标。
    private float yMove;

    //用于计算手指滑动的速度。
    private VelocityTracker mVelocityTracker;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        createVelocityTracker(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDown = event.getRawX();
                yDown = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                xMove = event.getRawX();
                yMove= event.getRawY();
                //滑动的距离
                int distanceX = (int) (xMove - xDown);
                int distanceY= (int) (yMove - yDown);
                //获取顺时速度
                int ySpeed = getScrollVelocity();
                //关闭Activity需满足以下条件：
                //1.x轴滑动的距离>XDISTANCE_MIN
                //2.y轴滑动的距离在YDISTANCE_MIN范围内
                //3.y轴上（即上下滑动的速度）<XSPEED_MIN，如果大于，则认为用户意图是在上下滑动而非左滑结束Activity
                if(distanceX > XDISTANCE_MIN &&(distanceY<YDISTANCE_MIN&&distanceY>-YDISTANCE_MIN)&& ySpeed < YSPEED_MIN) {
                    finish();
                }
                break;
            case MotionEvent.ACTION_UP:
                recycleVelocityTracker();
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    /**
     * 创建VelocityTracker对象，并将触摸界面的滑动事件加入到VelocityTracker当中。
     *
     * @param event
     *
     */
    private void createVelocityTracker(MotionEvent event) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);
    }

    /**
     * 回收VelocityTracker对象。
     */
    private void recycleVelocityTracker() {
        mVelocityTracker.recycle();
        mVelocityTracker = null;
    }

    /**
     *
     * @return 滑动速度，以每秒钟移动了多少像素值为单位。
     */
    private int getScrollVelocity() {
        mVelocityTracker.computeCurrentVelocity(1000);
        int velocity = (int) mVelocityTracker.getYVelocity();
        return Math.abs(velocity);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setToolBarTitle("Order Room");

        checkinTime = (EditText)findViewById(R.id.checkin_time);
        checkoutTime = (EditText)findViewById(R.id.checkout_time);
        location = (EditText)findViewById(R.id.location);
        price = (SeekBar)findViewById(R.id.price_seekBar);
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
                data.putString("type",type);
                data.putString("extra_requirements",extra_requirements.toString());

                Intent it = new Intent();
                it.putExtras(data);

               it.setClass(TenantOrderTempActivity.this,OrderResultsActivity.class);
                startActivity(it);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tenant_order_temp;
    }
}
