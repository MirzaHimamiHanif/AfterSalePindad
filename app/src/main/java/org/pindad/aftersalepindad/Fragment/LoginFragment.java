package org.pindad.aftersalepindad.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.pindad.aftersalepindad.MenuActivity;
import org.pindad.aftersalepindad.Model.Customer;
import org.pindad.aftersalepindad.R;
import org.pindad.aftersalepindad.Rest.ApiClient;
import org.pindad.aftersalepindad.Rest.ApiInterface;
import org.pindad.aftersalepindad.SaveSharedPreference;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {

    ApiInterface mApiInterface;
    private EditText username, password;
    List<Customer> KontakList;
    public LoginFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        username = (EditText) rootView.findViewById(R.id.username);
        password = (EditText) rootView.findViewById(R.id.password);
        Button login = (Button) rootView.findViewById(R.id.login);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });
        return rootView;
    }
    public void refresh() {
        Call<List<Customer>> kontakCall = mApiInterface.putLogin(username.getText().toString(), password.getText().toString());
        kontakCall.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                KontakList = response.body();
                try{
                    SaveSharedPreference.setUserName(getActivity(), username.getText().toString(), KontakList.get(0).getId_customer());
                    MenuActivity activity = (MenuActivity) getActivity();
                    activity.signIn();
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}