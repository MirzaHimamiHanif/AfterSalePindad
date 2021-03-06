package org.pindad.aftersalepindad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import org.pindad.aftersalepindad.Adapter.CatalogueAdapter;
import org.pindad.aftersalepindad.Adapter.SimpleMail;
import org.pindad.aftersalepindad.Adapter.ViewPagerAdapter;
import org.pindad.aftersalepindad.Model.DataTicketing;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.Model.PostTicketing;
import org.pindad.aftersalepindad.Rest.ApiClient;
import org.pindad.aftersalepindad.Rest.ApiInterface;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class BarangActivity extends AppCompatActivity {
    private ScrollView sView;
    private TextView mTxtOutput;
    private ViewPager viewPager;
    private TextView mNama, mDeskripsi;
    private Button mKirim;
    private DataTicketing dataTicketing;
    private EditText comment;
    ApiInterface mApiInterface;
    List<ListCatalogue> KontakList;
    String gambar;

    public static final int REQUEST_CODE_CAMERA = 0012;
    public static final int REQUEST_CODE_GALLERY = 0013;
    private Button btnLoadImage;
    private ImageView ivImage;
    private TextView tvPath;
    private String [] items = {"Camera","Gallery"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        btnLoadImage = (Button) findViewById(R.id.btn_take_image);
        ivImage = (ImageView) findViewById(R.id.image_view_image);
        tvPath = (TextView) findViewById(R.id.textview_image_path);

        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImage();
            }
        });

        mTxtOutput = (TextView)findViewById(R.id.txtOutput);
        mTxtOutput.setMovementMethod(ScrollingMovementMethod.getInstance());
        ScrollView sView = (ScrollView)findViewById(R.id.ScrollView01);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getIntent().getStringExtra("getPic"));
        viewPager.setAdapter(viewPagerAdapter);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        mKirim = (Button) findViewById(R.id.kirim);
        mNama = (TextView) findViewById(R.id.namaItem);
        dataTicketing = new DataTicketing();
        comment = (EditText) findViewById(R.id.comment);
        mNama.setText(getIntent().getStringExtra("getNama"));
        mTxtOutput.setText(getIntent().getStringExtra("getDeskripsi"));


        mKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DatabaseReference root = FirebaseDatabase.getInstance().getReference();
//                root.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot snapshot) {
//
//                        showData(snapshot);
////                        Uri path = Uri.parse(BASE_URL + "pdf");
////                        Intent intent = new Intent(Intent.ACTION_VIEW);
////                        intent.setDataAndType(
////                                path, "application/pdf");
////                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
            showData();
            }
        });
    }

    private void showData() {
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.m.setBody(comment.getText().toString());
        email.execute();
        if (comment.getText().toString().length() == 0) {
            comment.setError("Data Kosong");
        } else {
            Call<PostTicketing> postCatalogue = mApiInterface.postCatalogue(
                    "T0001",
                    SaveSharedPreference.getIdCustomer(getApplication()),
                    "1",
                    comment.getText().toString(),
                    "",
                    "Belum"
            );
            postCatalogue.enqueue(new Callback<PostTicketing>() {
                @Override
                public void onResponse(Call<PostTicketing> call, Response<PostTicketing> response) {

                    new AlertDialog.Builder(BarangActivity.this)
                            .setMessage("Pesan telah terkirim")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(BarangActivity.this, MenuActivity.class);
                                    overridePendingTransition(0, 0);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    finish();
                                    overridePendingTransition(0, 0);
                                    startActivity(intent);
                                }
                            }).show();
                }
                @Override
                public void onFailure(Call<PostTicketing> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error", LENGTH_LONG).show();
                }
            });
        }
    }

    private void openImage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){
                    EasyImage.openCamera(BarangActivity.this,REQUEST_CODE_CAMERA);
                }else if(items[i].equals("Gallery")){
                    EasyImage.openGallery(BarangActivity.this, REQUEST_CODE_GALLERY);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagesPicked(List<File> imageFiles, EasyImage.ImageSource source, int type) {
                switch (type){
                    case REQUEST_CODE_CAMERA:
                        Glide.with(BarangActivity.this)
                                .load(imageFiles)
                                .apply(new RequestOptions()
                                        .placeholder(R.drawable.placeholder)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                                .into(ivImage);
//                        tvPath.setText(imageFiles.getAbsolutePath());
                        break;
                    case REQUEST_CODE_GALLERY:
                        Glide.with(BarangActivity.this)
                                .load(imageFiles)
                                .apply(new RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL))
                                .into(ivImage);
//                        tvPath.setText(imageFiles.getAbsolutePath());
                        break;
                }
            }


        });
    }
    class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
        SimpleMail m = new SimpleMail();

        public SendEmailAsyncTask() {}

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                if (m.send()) {
                    return true;
                } else {return true;}
            } catch (AuthenticationFailedException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
                e.printStackTrace();
                return false;
            } catch (MessagingException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
                e.printStackTrace();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }


}

