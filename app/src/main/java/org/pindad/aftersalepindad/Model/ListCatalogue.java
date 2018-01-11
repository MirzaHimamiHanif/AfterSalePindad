package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

public class ListCatalogue {
    @SerializedName("nama")
    private String nama;
    @SerializedName("deskripsi")
    private String deskripsi;
    private int imageUrl;

    public ListCatalogue(String nama, String deskripsi, int imageUrl) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.imageUrl = imageUrl;
    }

    public ListCatalogue() {

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

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
