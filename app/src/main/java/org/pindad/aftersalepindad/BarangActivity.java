package org.pindad.aftersalepindad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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

import org.pindad.aftersalepindad.Adapter.CatalogueAdapter;
import org.pindad.aftersalepindad.Adapter.ViewPagerAdapter;
import org.pindad.aftersalepindad.Fragment.CatalogueFragment;
import org.pindad.aftersalepindad.Fragment.IsiDataFragment;
import org.pindad.aftersalepindad.Model.DataTicketing;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.Model.PostPulDelCatalogue;
import org.pindad.aftersalepindad.Rest.ApiClient;
import org.pindad.aftersalepindad.Rest.ApiInterface;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

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
                DatabaseReference root = FirebaseDatabase.getInstance().getReference();
                root.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        showData(snapshot);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    private void showData(DataSnapshot dataSnapshot) {
        final DataTicketing dataTicketing = new DataTicketing();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            dataTicketing.setEmail(ds.child(mUid).getValue(DataTicketing.class).getEmail()); //set the email
            dataTicketing.setNama(ds.child(mUid).getValue(DataTicketing.class).getNama()); //set the name
            dataTicketing.setNoTelp(ds.child(mUid).getValue(DataTicketing.class).getNoTelp());
            dataTicketing.setPerusahaan(ds.child(mUid).getValue(DataTicketing.class).getPerusahaan());
        }
        dataTicketing.setNama_barang(mNama.getText().toString());
        dataTicketing.setPesan(comment.getText().toString());
        Call<PostPulDelCatalogue> postCatalogue = mApiInterface.postCatalogue(
                dataTicketing.getNama(),
                dataTicketing.getPerusahaan(),
                dataTicketing.getNoTelp(),
                dataTicketing.getNama_barang(),
                dataTicketing.getPesan(),
                dataTicketing.getEmail()
        );
        postCatalogue.enqueue(new Callback<PostPulDelCatalogue>() {
            @Override
            public void onResponse(Call<PostPulDelCatalogue> call, Response<PostPulDelCatalogue> response) {
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
            }

            @Override
            public void onFailure(Call<PostPulDelCatalogue> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
