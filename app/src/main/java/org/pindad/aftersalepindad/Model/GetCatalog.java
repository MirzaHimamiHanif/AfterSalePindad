package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

import org.pindad.aftersalepindad.Model.ListCatalogue;

import java.util.List;

/**
 * Created by ASUS on 11/01/2018.
 */

public class GetCatalog {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<ListCatalogue> listDataKontak;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<ListCatalogue> getListCatalogue() {
        return listDataKontak;
    }
    public void setListCatalogue(List<ListCatalogue> listCatalogue) {
        this.listDataKontak = listCatalogue;
    }

}
