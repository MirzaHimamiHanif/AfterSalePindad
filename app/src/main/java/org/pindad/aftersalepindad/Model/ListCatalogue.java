package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCatalogue {
    @SerializedName("jenis_produk")
    private String jenis_produk;
    @SerializedName("tipe_produk")
    private String tipe_produk;
    private int imageUrl;

    public ListCatalogue(){

    }

    public ListCatalogue(String jenis_produk, String tipe_produk, int imageUrl) {
        this.jenis_produk = jenis_produk;
        this.tipe_produk = tipe_produk;
        this.imageUrl = imageUrl;
    }

    public String getJenis_produk() {
        return jenis_produk;
    }

    public void setJenis_produk(String jenis_produk) {
        this.jenis_produk = jenis_produk;
    }

    public String getTipe_produk() {
        return tipe_produk;
    }

    public void setTipe_produk(String tipe_produk) {
        this.tipe_produk = tipe_produk;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
