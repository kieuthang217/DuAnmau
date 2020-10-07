package com.example.myapplication.model;

import androidx.annotation.NonNull;

public class Sach {
    public String maSach;
    public String theLoaiSach;
    public String tenSach;
    public String tacGia;
    public String nxb;
    public float giaBan;
    public int soLuong;

    public Sach(String maSach, String theLoaiSach, String tenSach, String tacGia, String nxb, float giaBan, int soLuong) {
        this.maSach = maSach;
        this.theLoaiSach = theLoaiSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nxb = nxb;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public Sach() {
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTheLoaiSach() {
        return theLoaiSach;
    }

    public void setTheLoaiSach(String theLoaiSach) {
        this.theLoaiSach = theLoaiSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @NonNull
    @Override
    public String toString() {
        return this.tenSach;
    }
}
