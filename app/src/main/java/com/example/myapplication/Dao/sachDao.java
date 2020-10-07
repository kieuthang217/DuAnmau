package com.example.myapplication.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class sachDao {
    private SQLiteDatabase db;
    private Database dbManager;

    public static final String TABLE_NAME = "Sach";
    public static final String SQL_Sach = "CREATE TABLE Sach (maSach text primary key, theLoaiSach text, " +
            "tenSach text, tacGia text, nxb text, giaBan float, soLuong integer)";

    public sachDao(Context context) {
        dbManager = new Database(context);
        db = dbManager.getWritableDatabase();
    }

    public long insertSach(Sach sach) {
        ContentValues values = new ContentValues();
        values.put("maSach", sach.getMaSach());
        values.put("theLoaiSach", sach.getTheLoaiSach());
        values.put("tenSach", sach.getTenSach());
        values.put("tacGia", sach.getTacGia());
        values.put("nxb", sach.getNxb());
        values.put("giaBan", sach.getGiaBan());
        values.put("soLuong", sach.getSoLuong());

        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    public List<Sach> getAllSach() {
        List<Sach> sachList = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Sach sach = new Sach();
            sach.setMaSach(c.getString(0));
            sach.setTheLoaiSach(c.getString(1));
            sach.setTenSach(c.getString(2));
            sach.setTacGia(c.getString(3));
            sach.setNxb(c.getString(4));
            sach.setGiaBan(c.getFloat(5));
            sach.setSoLuong(c.getInt(6));
            sachList.add(sach);
            c.moveToNext();
        }
        c.close();
        return sachList;
    }

    public int updateSach(Sach sach) {
        ContentValues values = new ContentValues();
        values.put("maSach", sach.getMaSach());
        values.put("theLoaiSach", sach.getTheLoaiSach());
        values.put("tenSach", sach.getTenSach());
        values.put("tacGia", sach.getTacGia());
        values.put("nxb", sach.getNxb());
        values.put("giaBan", sach.getGiaBan());
        values.put("soLuong", sach.getSoLuong());

        int result = db.update(TABLE_NAME, values, "maSach=?", new String[]{sach.getMaSach()});
        if (result == 0) {
            return -1;
        } else {
            return 1;
        }

    }

    public int deleteSach(String maSach) {
        int result = db.delete(TABLE_NAME, "maSach=?", new String[]{maSach});
        if (result == 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public Sach getMaSachByTen(String name) {
        Sach sach = new Sach();

        String select = "SELECT * FROM " + TABLE_NAME + " WHERE tenSach=?";
        Cursor c = db.rawQuery(select, new String[]{name});

        c.moveToFirst();
        while (c.isAfterLast() == false) {
            sach.setMaSach(c.getString(0));
            sach.setTheLoaiSach(c.getString(1));
            sach.setTenSach(c.getString(2));
            sach.setTacGia(c.getString(3));
            sach.setNxb(c.getString(4));
            sach.setGiaBan(c.getFloat(5));
            sach.setSoLuong(c.getInt(6));
            c.moveToNext();
            c.close();
        }
        return sach;
    }
}
