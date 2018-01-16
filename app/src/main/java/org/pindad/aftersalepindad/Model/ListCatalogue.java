package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCatalogue {
    @SerializedName("nama")
    private String nama;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("kategori")
    private String kategori;
    private int imageUrl;

    public ListCatalogue(){

    }
    public ListCatalogue(String nama, String deskripsi, String kategori, int imageUrl) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.imageUrl = imageUrl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
