package com.example.luoxuechun.myapplication.serviceImpl;

import com.example.luoxuechun.myapplication.service.LoginService;

/**
 * Created by luoxuechun on 2017/5/19.
 */
public class LoginServiceImpl implements LoginService{
    @Override
    public boolean isTenant(String name, String password) {
        return false;
    }

    @Override
    public boolean isLandlord(String name, String password) {
        return false;
    }
}
