package com.example.th2_5.model;

public class HoaDon {
    private int soLuong;
    private double thanhTien;
    private KhachHang khachHang;
    public Double tinhThanhTien(){
        if(khachHang.isVip()){
            thanhTien=soLuong*20000-soLuong*20000*0.1;
        }
        else {
            thanhTien=soLuong*20000;
        }
        return this.thanhTien;

    }
    public int getSoLuong() {
        return soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public HoaDon(int soLuong,KhachHang khachHang) {
        this.soLuong = soLuong;
        this.khachHang=khachHang;

    }

}
