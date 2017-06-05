package com.example.luoxuechun.myapplication.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.luoxuechun.myapplication.R;

import org.w3c.dom.Text;


public class LoginActivity extends AppCompatActivity {
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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //remove the title
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

                //check the right of user

                if(true){
                    Intent intent=new Intent();
                    intent.setClass(LoginActivity.this,TenantOrderActivity.class);
                    startActivity(intent);
                }
            }
        });
        landlordLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameValue = et_name.getText().toString();
                passValue = et_pass.getText().toString();

                //check the right of user

                if(true){
                    Intent intent=new Intent();
                    intent.setClass(LoginActivity.this,RoomResultsDetailActivity.class);
                    startActivity(intent);
                }
            }
        });

//        WebView webview = new WebView(this);
//        //设置WebView属性，能够执行Javascript脚本
//        webview.getSettings().setJavaScriptEnabled(true);
//
//        try {
//            //设置打开的页面地址
//            webview.loadUrl("file:///android_asset/index_files/index.html");
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        setContentView(webview);
//
//
    }

}
