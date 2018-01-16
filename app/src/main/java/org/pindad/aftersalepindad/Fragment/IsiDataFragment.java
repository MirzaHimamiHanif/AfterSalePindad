package org.pindad.aftersalepindad.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.pindad.aftersalepindad.Data;
import org.pindad.aftersalepindad.MenuActivity;
import org.pindad.aftersalepindad.R;

public class IsiDataFragment extends Fragment {
    private TextView mText;
    private Button mButton;
    private EditText mNama, mPerusahaan, mNoTelp;
    private DatabaseReference mDatabase;
    private String mEmail, mUid;
    private static final int RC_SIGN_IN = 9001;

    public IsiDataFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_isi_data, container, false);
        mNama = (EditText) rootView.findViewById(R.id.nama);
        mPerusahaan = (EditText) rootView.findViewById(R.id.perusahaan);
        mNoTelp = (EditText) rootView.findViewById(R.id.telpon);
        mText = (TextView) rootView.findViewById(R.id.titleData);
        mButton = (Button) rootView.findViewById(R.id.save);
        MenuActivity activity = (MenuActivity) getActivity();
        mEmail = activity.getmEmail();
        mUid = activity.getmUid();

        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mNama.getText().toString().equals("")||mPerusahaan.getText().toString().equals("")||mNoTelp.getText().toString().equals("")){
                        new AlertDialog.Builder(getContext())
                        .setMessage("Semua Data Harus Diisi!")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).show();
                }else{
                    tambahData();
                    Intent intent = new Intent(getActivity(), MenuActivity.class);
                    startActivityForResult(intent, RC_SIGN_IN);
                }
            }
        });
        return rootView;
    }    private void tambahData(){
        Data data = new Data(mNama.getText().toString(),mPerusahaan.getText().toString(),mNoTelp.getText().toString(), mEmail);
        mDatabase.child(mUid).setValue(data);
    }

}
