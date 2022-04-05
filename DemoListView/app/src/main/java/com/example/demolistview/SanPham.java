package com.example.demolistview;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int ma;
    private String ten;
    private int hinhAnh;
    private double gia;
    private String moTa;

    @Override
    public String toString() {
        return "SanPham{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", hinhAnh=" + hinhAnh +
                ", gia=" + gia +
                ", moTa='" + moTa + '\'' +
                '}';
    }

    public SanPham(int ma, String ten, int hinhAnh, double gia, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.gia = gia;
        this.moTa = moTa;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
