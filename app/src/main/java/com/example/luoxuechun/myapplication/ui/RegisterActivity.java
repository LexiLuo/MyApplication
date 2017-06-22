package com.example.luoxuechun.myapplication.ui;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.luoxuechun.myapplication.R;
import com.example.luoxuechun.myapplication.utils.LinkToServer;

/**
 * Created by zcy on 2017/6/22.
 *
 */

public class RegisterActivity extends BaseAppCompatActivity{

    private EditText et_name,et_password,et_confirm,et_phone;
    private RadioButton btn1,btn2;
    private Button tenantBtn,landlordBtn;
    private String name_val,password_val,confirm_val,phone_val,gender,type;
    private final static String url = "/register";

    protected void onCreate(Bundle savedInstanceState) {
        //为了在主线程中访问网络，所以加了这两行
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_register);

        et_name = (EditText) findViewById(R.id.nameValue);
        et_password = (EditText) findViewById(R.id.passwordValue);
        et_confirm = (EditText) findViewById(R.id.password2Value);
        et_phone = (EditText) findViewById(R.id.phoneValue);
        btn1 = (RadioButton) findViewById(R.id.maleBtn);
        btn2 = (RadioButton) findViewById(R.id.femaleBtn);
        tenantBtn = (Button) findViewById(R.id.tenantRegister);
        landlordBtn = (Button) findViewById(R.id.landlordRegister);

        tenantBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                name_val = et_name.getText().toString();
                password_val = et_password.getText().toString();
                confirm_val = et_confirm.getText().toString();
                phone_val = et_phone.getText().toString();
                if(btn1.isChecked()){
                    gender = "male";
                }else if(btn2.isChecked()){
                    gender = "female";
                }else{
                    gender = "";
                }
                type = "tenant";

                if(name_val.equals("")||password_val.equals("")){
                    new AlertDialog.Builder(RegisterActivity.this).setTitle("Fail")
                            .setMessage("Information is missing！")
                            .setPositiveButton("Ok", null)
                            .show();
                }
                if(!password_val.equals(confirm_val)){
                    new AlertDialog.Builder(RegisterActivity.this).setTitle("Fail")
                            .setMessage("Please check your password！")
                            .setPositiveButton("Ok", null)
                            .show();
                }

                String param = "{\"id\":\"20\""+
                                ",\"name\":"+"\""+name_val+"\""+
                                ",\"password\":"+"\""+password_val+"\""+
                                ",\"gender\":"+"\""+gender+"\""+
                                ",\"phonenum\":"+"\""+phone_val+"\""+
                                ",\"preference\":\"\""+
                                ",\"education\":\"\""+
                                ",\"vocation\":\"\""+
                                ",\"economic\":\"\"}";
                String result = LinkToServer.sendPost(url+"/tenant",param);
                new AlertDialog.Builder(RegisterActivity.this).setTitle("Success")
                        .setMessage(result)
                        .setPositiveButton("Ok", null)
                        .show();
                //TODO 自动跳转到登录界面
            }
        });

        landlordBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                name_val = et_name.getText().toString();
                password_val = et_password.getText().toString();
                confirm_val = et_confirm.getText().toString();
                phone_val = et_phone.getText().toString();
                if(btn1.isChecked()){
                    gender = "male";
                }else if(btn2.isChecked()){
                    gender = "female";
                }else{
                    gender = "";
                }
                type = "landlord";

                if(name_val.equals("")||password_val.equals("")){
                    new AlertDialog.Builder(RegisterActivity.this).setTitle("Fail")
                            .setMessage("Information is missing！")
                            .setPositiveButton("Ok", null)
                            .show();
                }
                if(!password_val.equals(confirm_val)){
                    new AlertDialog.Builder(RegisterActivity.this).setTitle("Fail")
                            .setMessage("Please check your password！")
                            .setPositiveButton("Ok", null)
                            .show();
                }

                String param = "{\"id\":\"20\""+
                        ",\"name\":"+"\""+name_val+"\""+
                        ",\"password\":"+"\""+password_val+"\""+
                        ",\"gender\":"+"\""+gender+"\""+
                        ",\"phonenum\":"+"\""+phone_val+"\""+
                        ",\"preference\":\"\""+
                        ",\"education\":\"\""+
                        ",\"vocation\":\"\""+
                        ",\"economic\":\"\"}";
                String result = LinkToServer.sendPost(url+"/landlord",param);
                new AlertDialog.Builder(RegisterActivity.this).setTitle("Success")
                        .setMessage(result)
                        .setPositiveButton("Ok", null)
                        .show();
                //TODO 自动跳转到登录界面
            }
        });

        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
