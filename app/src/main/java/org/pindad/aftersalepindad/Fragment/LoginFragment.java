package org.pindad.aftersalepindad.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.SignInButton;

import org.pindad.aftersalepindad.MenuActivity;
import org.pindad.aftersalepindad.R;

import java.util.Arrays;
import java.util.EventListener;


public class LoginFragment extends Fragment {
    private static final int RC_SIGN_IN = 123;

    public LoginFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        SignInButton signInButton = (SignInButton) rootView.findViewById(R.id.sign_in_button);
        Button signInEmail = (Button) rootView.findViewById(R.id.signInEmail);
        TextView textGoogle = (TextView) signInButton.getChildAt(0);
        textGoogle.setText("Sign In With Google");
        final TextView textView = (TextView) rootView.findViewById(R.id.title_text);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuActivity activity = (MenuActivity) getActivity();
                activity.signIn();
            }
        });
        signInEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()
                                ))
                                .build(),
                        RC_SIGN_IN);
            }
        });
        return rootView;
    }
}
