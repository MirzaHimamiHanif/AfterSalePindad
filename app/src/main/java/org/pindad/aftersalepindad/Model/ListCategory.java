package org.pindad.aftersalepindad.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WIDHIYANTO NUGROHO on 02/02/2018.
 */

public class ListCategory {

    @SerializedName("name_category")
    private String name_category;
    @SerializedName("image_category")
    private String image_category;


    public ListCategory() {

    }

    public ListCategory(String name_category, String image_category) {
        this.name_category = name_category;
        this.image_category = image_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getImage_category() {
        return image_category;
    }

    public void setImage_category(String image_category) {
        this.image_category = image_category;
    }
}
