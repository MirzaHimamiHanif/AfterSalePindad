package org.pindad.aftersalepindad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pindad.aftersalepindad.Adapter.SimpleMail;
import org.pindad.aftersalepindad.Adapter.ViewPagerAdapter;
import org.pindad.aftersalepindad.Model.DataTicketing;
import org.pindad.aftersalepindad.Model.PostTicketing;
import org.pindad.aftersalepindad.Rest.ApiClient;
import org.pindad.aftersalepindad.Rest.ApiInterface;

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
    private FirebaseAuth mAuth;
    private EditText comment;
    ApiInterface mApiInterface;
    private String mUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);
        mTxtOutput = (TextView)findViewById(R.id.txtOutput);
        mTxtOutput.setMovementMethod(ScrollingMovementMethod.getInstance());
        ScrollView sView = (ScrollView)findViewById(R.id.ScrollView01);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        mKirim = (Button) findViewById(R.id.kirim);
        mNama = (TextView) findViewById(R.id.namaItem);
        dataTicketing = new DataTicketing();
        comment = (EditText) findViewById(R.id.comment);
        mNama.setText(getIntent().getStringExtra("getNama"));
        mTxtOutput.setText(getIntent().getStringExtra("getDeskripsi"));
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = mAuth.getCurrentUser();
        mUid = currentUser.getUid();
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
        try {
            String to = "zamif07@gmail.com";
            String subject = "Tes";
            String message = comment.getText().toString();
            //everything is filled out
            //send email
            new SimpleMail().sendEmail(to, subject, message);
            new AlertDialog.Builder(BarangActivity.this)
                    .setMessage("Pesan telah terkirim")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = getIntent();
                            overridePendingTransition(0, 0);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(intent);
                        }
                    }).show();
        } catch (Exception e) {
            e.printStackTrace();

        }


//        Call<PostTicketing> postCatalogue = mApiInterface.postCatalogue(
//                dataTicketing.getNama(),
//                dataTicketing.getPerusahaan(),
//                dataTicketing.getNoTelp(),
//                dataTicketing.getNama_barang(),
//                dataTicketing.getPesan(),
//                dataTicketing.getEmail()
//        );
//        postCatalogue.enqueue(new Callback<PostTicketing>() {
//            @Override
//            public void onResponse(Call<PostTicketing> call, Response<PostTicketing> response) {
//                new AlertDialog.Builder(BarangActivity.this)
//                        .setMessage("Pesan telah terkirim")
//                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Intent intent = getIntent();
//                                overridePendingTransition(0, 0);
//                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                                finish();
//                                overridePendingTransition(0, 0);
//                                startActivity(intent);
//                            }
//                        }).show();
//            }
//
//            @Override
//            public void onFailure(Call<PostTicketing> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Error", LENGTH_LONG).show();
//            }
//        });
    }
}

