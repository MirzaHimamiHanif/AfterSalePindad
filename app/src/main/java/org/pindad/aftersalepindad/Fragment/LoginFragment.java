package org.pindad.aftersalepindad.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.SignInButton;

import org.pindad.aftersalepindad.MenuActivity;
import org.pindad.aftersalepindad.R;

import java.util.EventListener;


public class LoginFragment extends Fragment {

    public LoginFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        SignInButton signInButton = (SignInButton) rootView.findViewById(R.id.sign_in_button);
        final TextView textView = (TextView) rootView.findViewById(R.id.title_text);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuActivity activity = (MenuActivity) getActivity();
                activity.signIn();
            }
        });
        return rootView;
    }
}
