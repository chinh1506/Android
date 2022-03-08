package com.example.th2_5.model;

public class KhachHang {
    private String tenKh;
    private boolean vip;

    @Override
    public String toString() {
        return "KhachHang{" +
                "tenKh='" + tenKh + '\'' +
                ", vip=" + vip +
                '}';
    }

    public KhachHang(String tenKh, boolean vip) {
        this.tenKh = tenKh;
        this.vip = vip;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
