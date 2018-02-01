package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCatalogue {
    @SerializedName("jenis_produk")
    private String jenis_produk;
    @SerializedName("tipe_produk")
    private String tipe_produk;
    @SerializedName("pic")
    private String pic;



//    private int imageUrl;

    public ListCatalogue(){

        }

    public ListCatalogue(String jenis_produk, String tipe_produk, String pic) {
            this.jenis_produk = jenis_produk;
        this.tipe_produk = tipe_produk;
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.jenis_produk.equals(((ListCatalogue) obj).jenis_produk));
    }

}
