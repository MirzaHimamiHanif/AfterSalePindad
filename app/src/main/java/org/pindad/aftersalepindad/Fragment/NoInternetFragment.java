package org.pindad.aftersalepindad.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.pindad.aftersalepindad.MenuActivity;
import org.pindad.aftersalepindad.R;

public class NoInternetFragment extends Fragment {
    public NoInternetFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_no_internet, container, false);
        return rootView;
    }
}
