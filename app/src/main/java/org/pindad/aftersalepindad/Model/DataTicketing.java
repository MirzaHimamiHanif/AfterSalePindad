package org.pindad.aftersalepindad.Model;

/**
 * Created by ASUS on 12/01/2018.
 */

public class DataTicketing {
    private String nama, perusahaan, telp, nama_barang, pesan, email;

    public DataTicketing(){

    }

    public DataTicketing(String nama, String perusahaan, String telp, String nama_barang, String pesan, String email) {
        this.nama = nama;
        this.perusahaan = perusahaan;
        this.telp = telp;
        this.nama_barang = nama_barang;
        this.pesan = pesan;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
