package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WIDHIYANTO NUGROHO on 18/01/2018.
 */

public class ListVideo {

    @SerializedName("nama_video")
    private String nama_video;

    @SerializedName("kategori")
    private String kategori;
    private int imageUrl;

    public ListVideo() {
    }

    public ListVideo(String nama_video, String kategori, int imageUrl) {
        this.nama_video = nama_video;
        this.kategori = kategori;
        this.imageUrl = imageUrl;
    }

    public String getNama_video() {
        return nama_video;
    }

    public void setNama_video(String nama_video) {
        this.nama_video = nama_video;
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
