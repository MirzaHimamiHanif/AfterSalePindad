package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 25/01/2018.
 */

public class Customer {
    @SerializedName("id_cutomer")
    private String id_customer;

    public Customer(){

    }
    public Customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }
}
