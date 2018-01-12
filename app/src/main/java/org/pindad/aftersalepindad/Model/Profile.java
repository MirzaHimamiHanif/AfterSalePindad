package org.pindad.aftersalepindad.Model;

/**
 * Created by ASUS on 12/01/2018.
 */

public class Profile {
    String email, nama, noTelp, perusahaan;

    public Profile(){

    }
    public Profile(String email, String nama, String noTelp, String perusahaan) {
        this.email = email;
        this.nama = nama;
        this.noTelp = noTelp;
        this.perusahaan = perusahaan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }
}
