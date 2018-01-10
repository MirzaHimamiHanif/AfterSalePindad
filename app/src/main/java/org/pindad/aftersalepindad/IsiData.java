package org.pindad.aftersalepindad;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class IsiData extends AppCompatActivity{
    private TextView mText;
    private Button mButton;
    private EditText mNama, mPerusahaan, mNoTelp;
    private DatabaseReference mDatabase;
    private String mEmail, mUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data);
        Bundle extras = getIntent().getExtras();
        mNama = (EditText) findViewById(R.id.nama);
        mPerusahaan = (EditText) findViewById(R.id.perusahaan);
        mNoTelp = (EditText) findViewById(R.id.telpon);
        mText = (TextView) findViewById(R.id.titleData);
        mButton = (Button) findViewById(R.id.save);
        mEmail = extras.getString("user");
        mUid = extras.getString("uid");
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahData();
                Log.d("Tes ", "Berhasil");
                Intent intent = new Intent(IsiData.this, MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    private void tambahData(){
        Data data = new Data(mNama.getText().toString(),mPerusahaan.getText().toString(),mNoTelp.getText().toString(), mEmail);
        mDatabase.child(mUid).setValue(data);
    }
}