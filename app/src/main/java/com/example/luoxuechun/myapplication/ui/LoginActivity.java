package com.example.luoxuechun.myapplication.ui;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luoxuechun.myapplication.R;
import com.example.luoxuechun.myapplication.utils.LinkToServer;

import org.w3c.dom.Text;


public class LoginActivity extends BaseAppCompatActivity {
    /*
     * register：
     * tenant login：
     * landlord login：
     * @author LexiLuo
     *
     */
    private EditText et_name, et_pass;
    private TextView registerLink;
    private Button tenantLoginButton, landlordLoginButton;
    private String nameValue, passValue;
    private String type;
    private final static String url = "/login";
//    private TextView mToolbarTitle;
//    private TextView mToolbarSubTitle;
//    private Toolbar mToolbar;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //为了在主线程中访问网络，所以加了这两行
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //remove the title
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setToolBarTitle("Login");
       // setContentView(R.layout.activity_login);


        et_name = (EditText) findViewById(R.id.nameText);
        et_pass = (EditText) findViewById(R.id.passwordText);
        tenantLoginButton = (Button) findViewById(R.id.tenantButton);
        landlordLoginButton = (Button) findViewById(R.id.landlordButton);
        registerLink=(TextView)findViewById(R.id.registerLink);
        tenantLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameValue = et_name.getText().toString();
                passValue = et_pass.getText().toString();
                type = "tenant";
                //check the right of user
                String param = "{\"name\":"+"\""+nameValue+"\""+",\"password\":"+"\""+passValue+"\""+",\"type\":"+"\""+type+"\"}";
                Log.v("param",param);
                String result = LinkToServer.sendPost(url,param);
                Log.v("loginact",result);
                if(result!=null && result.length()!=0){
                    Intent intent=new Intent();
                    intent.setClass(LoginActivity.this,TenantOrderTempActivity.class);
                    startActivity(intent);
                }else{
                    new AlertDialog.Builder(LoginActivity.this).setTitle("登录失败")
                            .setMessage("账号不存在或密码错误！")
                            .setPositiveButton("Ok", null)
                            .show();
                }
            }
        });
        landlordLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameValue = et_name.getText().toString();
                passValue = et_pass.getText().toString();
                type = "landlord";
                //check the right of user

                String param = "{\"name\":"+"\""+nameValue+"\""+",\"password\":"+"\""+passValue+"\""+",\"type\":"+"\""+type+"\"}";
                String result = LinkToServer.sendPost(url,param);
                if(result!=null && result.length()!=0){
                    Intent intent=new Intent();
                    intent.setClass(LoginActivity.this,TenantOrderTempActivity.class);
                    startActivity(intent);
                }else{
                    new AlertDialog.Builder(LoginActivity.this).setTitle("登录失败")
                            .setMessage("账号不存在或密码错误！")
                            .setPositiveButton("Ok", null)
                            .show();
                }
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


}
