package org.pindad.aftersalepindad.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 11/01/2018.
 */

public class ApiClient {
//    public static final String BASE_URL = "http://192.168.137.1/rest_ci/index.php/";
//    public static final String BASE_URL = "https://aftersales-api-dev.pindad.com/index.php/";
    public static final String BASE_URL = "http://192.168.44.1/rest_ci/index.php/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
