package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 11/01/2018.
 */

public class PostPulDelCatalogue {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    DataTicketing mDataTicketing;
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
    public DataTicketing getDataTicketing() {
        return mDataTicketing;
    }
    public void setDataTicketing(DataTicketing dataTicketing) {
        mDataTicketing = dataTicketing;
    }
}
