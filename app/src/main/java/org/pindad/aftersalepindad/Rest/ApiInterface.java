package org.pindad.aftersalepindad.Rest;
import org.pindad.aftersalepindad.Model.Customer;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.Model.ListVideo;
import org.pindad.aftersalepindad.Model.PostTicketing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface ApiInterface {
    @GET("barang")
    Call<List<ListCatalogue>> getCatalogue();

    @GET("video")
    Call<List<ListVideo>> getVideo();

    @FormUrlEncoded
    @POST("ticketing")
    Call<PostTicketing> postCatalogue(@Field("no_ticket") String no_ticket,
                                      @Field("id_user") String id_user,
                                      @Field("id_produk") String id_produk,
                                      @Field("issue") String issue,
                                      @Field("ip_address") String ip_address,
                                      @Field("status") String status);

    @FormUrlEncoded
    @PUT("login")
    Call<List<Customer>> putLogin(@Field("username") String username,
                            @Field("password") String password);
}
