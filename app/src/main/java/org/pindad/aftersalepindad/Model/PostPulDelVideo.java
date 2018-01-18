package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WIDHIYANTO NUGROHO on 18/01/2018.
 */

public class PostPulDelVideo {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    DataTicketing mDataVideo;
    @SerializedName("message")
    String message;

    public PostPulDelVideo() {
    }

    public PostPulDelVideo(String status, DataTicketing mDataVideo, String message) {
        this.status = status;
        this.mDataVideo = mDataVideo;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataTicketing getmDataVideo() {
        return mDataVideo;
    }

    public void setmDataVideo(DataTicketing mDataVideo) {
        this.mDataVideo = mDataVideo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
