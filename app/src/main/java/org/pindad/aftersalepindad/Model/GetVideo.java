package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WIDHIYANTO NUGROHO on 18/01/2018.
 */

public class GetVideo {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<ListVideo> listDataKontak;
    @SerializedName("message")
    String message;

    public GetVideo() {
    }

    public GetVideo(String status, List<ListVideo> listDataKontak, String message) {
        this.status = status;
        this.listDataKontak = listDataKontak;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ListVideo> getListDataKontak() {
        return listDataKontak;
    }

    public void setListDataKontak(List<ListVideo> listDataKontak) {
        this.listDataKontak = listDataKontak;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
