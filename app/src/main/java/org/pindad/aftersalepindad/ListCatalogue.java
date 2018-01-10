package org.pindad.aftersalepindad;

public class ListCatalogue {
    private String nama;
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
