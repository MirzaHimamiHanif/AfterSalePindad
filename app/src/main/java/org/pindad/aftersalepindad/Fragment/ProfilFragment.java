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

import org.pindad.aftersalepindad.R;


public class ProfilFragment extends Fragment {

    TextView name, email, phone, office;
    ImageView photo, background;

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_profil, null);

        background = (ImageView) rootView.findViewById(R.id.profil_background);
        photo = (ImageView) rootView.findViewById(R.id.profil_photo);
        name = (TextView) rootView.findViewById(R.id.profil_name);
        office = (TextView) rootView.findViewById(R.id.profil_office);
        email = (TextView) rootView.findViewById(R.id.profil_email);
        phone = (TextView) rootView.findViewById(R.id.profil_phone);
        return rootView;
    }
}
