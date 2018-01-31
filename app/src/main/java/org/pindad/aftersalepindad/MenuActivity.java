package org.pindad.aftersalepindad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


import org.pindad.aftersalepindad.Fragment.CatalogueFragment;
import org.pindad.aftersalepindad.Fragment.FaqFragment;
import org.pindad.aftersalepindad.Fragment.LoginFragment;
import org.pindad.aftersalepindad.Fragment.PrivacyFragment;
import org.pindad.aftersalepindad.Fragment.ProfilFragment;
import org.pindad.aftersalepindad.Fragment.TermFragment;
import org.pindad.aftersalepindad.Rest.ApiInterface;

import static android.view.View.GONE;

public class MenuActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public FragmentManager fragmentManager;
    private ProgressBar mProgressBar;
    private BottomNavigationView navigation;
    ApiInterface mApiInterface;
    String id_customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerL);
        navigationView = (NavigationView) findViewById(R.id.navdraw);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        try{
            if(SaveSharedPreference.getUserName(MenuActivity.this).length() == 0)
            {
                // call Login Activity
            }
            signIn();
        }catch (NullPointerException e){
            navigation.setVisibility(GONE);
            mProgressBar.setVisibility(View.GONE);
            LoginFragment loginFragment = new LoginFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.loginContainer, loginFragment)
                    .commit();
        }// Check if user is signed in (non-null) and update UI accordingly.
    }

    public void signIn() {
        FrameLayout loginContainer = (FrameLayout) findViewById(R.id.loginContainer);
        loginContainer.setVisibility(GONE);
        navigation.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        CatalogueFragment catalogueFragment = new CatalogueFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.catalogueContainer, catalogueFragment)
                .commit();
    }
    private void updateUI() {
        if (true) {
            FrameLayout loginContainer = (FrameLayout) findViewById(R.id.loginContainer);
            loginContainer.setVisibility(GONE);
            navigation.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
            CatalogueFragment catalogueFragment = new CatalogueFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.catalogueContainer, catalogueFragment)
                    .commit();
        }else{
            navigation.setVisibility(GONE);
            mProgressBar.setVisibility(View.GONE);
            LoginFragment loginFragment = new LoginFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.loginContainer, loginFragment)
                    .commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   cek("catalogue");
                    return true;
                case R.id.navigation_dashboard:
                    cek("faq");

                    return true;
                case R.id.navigation_notifications:
                    cek("menu");

                    return true;
            }
            return false;
        }
    };
    public void cek(String tes){
        switch (tes){
            case "catalogue" :
                CatalogueFragment catalogueFragment = new CatalogueFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.catalogueContainer, catalogueFragment)
                        .commit();
                break;
            case "faq" :
//                Intent i = new  Intent(MenuActivity.this, MenuVideoActivity.class);
//                startActivity(i);
                FaqFragment faqFragment = new FaqFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.catalogueContainer, faqFragment)
                        .commit();
                break;
            case "menu" :
                drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.navigation1) {
            ProfilFragment profilFragment = new ProfilFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.catalogueContainer, profilFragment)
                    .commit();
            return false;
        }else if (item.getItemId() == R.id.navigation2) {
            TermFragment termFragment = new TermFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.catalogueContainer, termFragment)
                    .commit();
            return false;
        }else if (item.getItemId() == R.id.navigation3) {
            PrivacyFragment privacyFragment = new PrivacyFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.catalogueContainer, privacyFragment)
                    .commit();
            return false;
        }else if (item.getItemId() == R.id.navigation5) {
//            VideoFragment videoFragment = new VideoFragment();
//            fragmentManager.beginTransaction()
//                    .replace(R.id.catalogueContainer, videoFragment)
//                    .commit();
            Intent i = new  Intent(MenuActivity.this, VideoActivity.class);
            startActivity(i);
        }else if (item.getItemId() == R.id.navigation6) {
            Intent i = new  Intent(MenuActivity.this, QuisionerActivity.class);
            startActivity(i);
        }else if (item.getItemId() == R.id.navigation4) {
            SaveSharedPreference.deletePreference(this);
            Intent intent = getIntent();
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();
            overridePendingTransition(0, 0);
            startActivity(intent);
        }
        return false;
    }

    public void displayMessage(String s) {
    }
}
