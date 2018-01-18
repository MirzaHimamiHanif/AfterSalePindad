package org.pindad.aftersalepindad.Rest;

import org.pindad.aftersalepindad.Model.DataTicketing;
import org.pindad.aftersalepindad.Model.GetCatalog;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.Model.PostPulDelCatalogue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by ASUS on 11/01/2018.
 */

public interface ApiInterface {
    @GET("barang")
    Call<List<ListCatalogue>> getCatalogue();
    
    @GET("ticketing")
    Call<List<DataTicketing>> getDataTicketing();
    @FormUrlEncoded

    @POST("ticketing")
    Call<PostPulDelCatalogue> postCatalogue(@Field("nama") String nama,
                                         @Field("perusahaan") String perusahaan,
                                            @Field("telp") String telp,
                                            @Field("nama_barang") String nama_barang,
                                            @Field("pesan") String pesan,
                                            @Field("email") String email);
    @FormUrlEncoded
    @PUT("kontak")
    Call<PostPulDelCatalogue> putCatalogue(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<PostPulDelCatalogue> deleteCatalogue(@Field("id") String id);

}
