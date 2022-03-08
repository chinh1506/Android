package com.example.hocthem.model;

public class TraiCay {
    private String name;
    private String moTa;
    private int hinh;

    public TraiCay() {
    }

    public TraiCay(String name, String moTa, int hinh) {
        this.name = name;
        this.moTa = moTa;
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "TraiCay{" +
                "name='" + name + '\'' +
                ", moTa='" + moTa + '\'' +
                ", hinh=" + hinh +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
