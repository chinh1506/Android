package com.example.onthigiuaky;

import java.util.Objects;

public class SinhVien {
    private int ma;
    private String thongTin;

    @Override
    public String toString() {
        return ma+"-"+thongTin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhVien)) return false;
        SinhVien sinhVien = (SinhVien) o;
        return getMa() == sinhVien.getMa();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMa());
    }

    public SinhVien() {
    }

    public SinhVien(int ma, String thongTin) {
        this.ma = ma;
        this.thongTin = thongTin;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }
}
