package com.example.luoxuechun.myapplication.entity;

import java.util.ArrayList;

/**
 * Created by luoxuechun on 2017/6/5.
 */

/**
 * 订单结果元素的实体，每个实体代表一个系统反馈的应标酒店
 */

public class OrderResultsEntity {
    private double originPrice; //原价
    private double currentPrice;//现价
    private String location;//酒店地址
    private String name;//酒店名称
    private double points;//系统评分
    private ArrayList<String> tags;//酒店标签

    public OrderResultsEntity(double originPrice,double currentPrice,String location,String name,double points,ArrayList<String> tags){
        this.originPrice=originPrice;
        this.currentPrice=currentPrice;
        this.location=location;
        this.name=name;
        this.points=points;
        this.tags=tags;

    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
