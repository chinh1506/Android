package com.example.uidemo;

import android.net.Uri;

public class NhanVien {
    private int ma;
    private String hoTen;
    private boolean gioiTinh;
    private String donVi;
    private Uri hinh;

    @Override
    public String toString() {
        return "NhanVien{" +
                "ma=" + ma +
                ", hoTen='" + hoTen + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", donVi='" + donVi + '\'' +
                '}';
    }

    public NhanVien() {
    }

    public Uri getHinh() {
        return hinh;
    }

    public void setHinh(Uri hinh) {
        this.hinh = hinh;
    }

    public NhanVien(int ma, String hoTen, boolean gioiTinh, String donVi, Uri hinh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
        this.hinh=hinh;
    }



    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }
}
