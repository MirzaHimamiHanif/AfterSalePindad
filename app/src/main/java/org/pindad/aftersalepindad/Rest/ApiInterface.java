package org.pindad.aftersalepindad.Rest;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.Model.ListVideo;
import org.pindad.aftersalepindad.Model.PostTicketing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {
    @GET("barang")
    Call<List<ListCatalogue>> getCatalogue();

    @GET("video")
    Call<List<ListVideo>> getVideo();

    @FormUrlEncoded
    @POST("ticketing")
    Call<PostTicketing> postCatalogue(@Field("nama") String nama,
                                      @Field("perusahaan") String perusahaan,
                                      @Field("telp") String telp,
                                      @Field("nama_barang") String nama_barang,
                                      @Field("pesan") String pesan,
                                      @Field("email") String email);
}
