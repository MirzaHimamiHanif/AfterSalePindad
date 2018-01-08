package org.pindad.aftersalepindad;

/**
 * Created by ASUS on 08/01/2018.
 */

public class Data {
    private String nama;
    private String perusahaan;
    private String noTelp;
    private String email;

    public Data(String nama, String perusahaan, String noTelp, String email) {
        this.nama = nama;
        this.perusahaan = perusahaan;
        this.noTelp = noTelp;
        this.email = email;
    }

    public Data(){

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

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
