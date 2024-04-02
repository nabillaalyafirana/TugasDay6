package com.example.recycleviewdancardview;

public class SkincareModel {
    private String namaSkincare;
    private int gambarSkincare;
    private String deskripsiSkincare;
    private double hargaSkincare;

    public SkincareModel(String namaSkincare, int gambarSkincare, String deskripsiSkincare, double hargaSkincare) {
        this.namaSkincare = namaSkincare;
        this.gambarSkincare = gambarSkincare;
        this.deskripsiSkincare = deskripsiSkincare;
        this.hargaSkincare = hargaSkincare;
    }

    public String getNamaSkincare() {
        return namaSkincare;
    }

    public void setNamaSkincare(String namaSkincare) { this.namaSkincare = namaSkincare; }

    public int getGambarSkincare() {
        return gambarSkincare;
    }

    public void setGambarSkincare(int gambarSkincare) {
        this.gambarSkincare = gambarSkincare;
    }

    public String getDeskripsiSkincare() {
        return deskripsiSkincare;
    }

    public void setDeskripsiSkincare(String deskripsiSkincare) { this.deskripsiSkincare = deskripsiSkincare;}

    public double getHargaSkincare() { return hargaSkincare; }

    public void setHargaSkincare(double hargaSkincare) { this.hargaSkincare = hargaSkincare; }



}
