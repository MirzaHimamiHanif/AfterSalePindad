package org.pindad.aftersalepindad.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pindad.aftersalepindad.BarangActivity;
import org.pindad.aftersalepindad.Model.DataTicketing;
import org.pindad.aftersalepindad.Model.PostTicketing;
import org.pindad.aftersalepindad.R;

import retrofit2.Call;

public class ProfilFragment extends Fragment {

    TextView name, email, phone, office;
    ImageView photo, background;
    private FirebaseAuth mAuth;
    private String mUid;

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_profil, container, false);

        background = (ImageView) rootView.findViewById(R.id.profil_background);
        photo = (ImageView) rootView.findViewById(R.id.profil_photo);
        name = (TextView) rootView.findViewById(R.id.profil_name);
        office = (TextView) rootView.findViewById(R.id.profil_office);
        email = (TextView) rootView.findViewById(R.id.profil_email);
        phone = (TextView) rootView.findViewById(R.id.profil_phone);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = mAuth.getCurrentUser();
        mUid = currentUser.getUid();
        DatabaseReference root = FirebaseDatabase.getInstance().getReference();
        root.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    email.setText(ds.child(mUid).getValue(DataTicketing.class).getEmail()); //set the email
                    name.setText(ds.child(mUid).getValue(DataTicketing.class).getNama()); //set the name
                    phone.setText(ds.child(mUid).getValue(DataTicketing.class).getNoTelp());
                    office.setText(ds.child(mUid).getValue(DataTicketing.class).getPerusahaan());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView;
    }
}
