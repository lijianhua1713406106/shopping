package com.offcn.shop.bean;

/**
 * Created by Administrator on 2020/11/25 0025.
 */
public class Product {
    private int proId;
    private String proName;
    private String proNum;
    private double marketPrice;
    private double shopPrice;
    private String proColor;
    private int proTotalCount;
    private String proMaxImg;
    private String proMinImg;
    private int prostate;

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proNum='" + proNum + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", proColor='" + proColor + '\'' +
                ", proTotalCount=" + proTotalCount +
                ", proMaxImg='" + proMaxImg + '\'' +
                ", proMinImg='" + proMinImg + '\'' +
                ", prodate=" + prostate +
                '}';
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProNum() {
        return proNum;
    }

    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public int getProTotalCount() {
        return proTotalCount;
    }

    public void setProTotalCount(int proTotalCount) {
        this.proTotalCount = proTotalCount;
    }

    public String getProMaxImg() {
        return proMaxImg;
    }

    public void setProMaxImg(String proMaxImg) {
        this.proMaxImg = proMaxImg;
    }

    public String getProMinImg() {
        return proMinImg;
    }

    public void setProMinImg(String proMinImg) {
        this.proMinImg = proMinImg;
    }

    public int getProstate() {
        return prostate;
    }

    public void setProstatee(int prodate) {
        this.prostate = prodate;
    }
}
