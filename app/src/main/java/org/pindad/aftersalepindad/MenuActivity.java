package org.pindad.aftersalepindad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.pindad.aftersalepindad.Fragment.CatalogueFragment;
import org.pindad.aftersalepindad.Fragment.FaqFragment;
import org.pindad.aftersalepindad.Fragment.IsiDataFragment;
import org.pindad.aftersalepindad.Fragment.LoginFragment;
import org.pindad.aftersalepindad.Fragment.PrivacyFragment;
import org.pindad.aftersalepindad.Fragment.ProfilFragment;
import org.pindad.aftersalepindad.Fragment.TermFragment;
import org.pindad.aftersalepindad.Fragment.VideoFragment;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MenuActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public FragmentManager fragmentManager;
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    private String mEmail, mUid;
    private ProgressBar mProgressBar;
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInClient mGoogleSignInClient;
    private BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerL);
        navigationView = (NavigationView) findViewById(R.id.navdraw);
        navigationView.setNavigationItemSelectedListener(this);
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        fragmentManager = getSupportFragmentManager();
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    // [END on_start_check_user]

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUI(null);
                // [END_EXCLUDE]
            }
        }else {

        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        showProgressDialog("Authentication...");
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            hideProgressDialog();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            hideProgressDialog();
                            updateUI(null);
                        }

                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    public String getmUid(){
        return mUid;
    }
    public String getmEmail(){
        return mEmail;
    }
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            FrameLayout loginContainer = (FrameLayout) findViewById(R.id.loginContainer);
            loginContainer.setVisibility(GONE);
            navigation.setVisibility(View.VISIBLE);
            mEmail = user.getEmail();
            mUid = user.getUid();
            mProgressBar.setVisibility(View.VISIBLE);
            DatabaseReference root = FirebaseDatabase.getInstance().getReference();
            DatabaseReference users = root.child("users").child(mUid);
            users.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        mProgressBar.setVisibility(View.GONE);
                        CatalogueFragment catalogueFragment = new CatalogueFragment();
                        fragmentManager.beginTransaction()
                                .replace(R.id.catalogueContainer, catalogueFragment)
                                .commit();
                    }else{
                        navigation.setVisibility(GONE);
                        mProgressBar.setVisibility(View.GONE);
                        FrameLayout isiDataContainer = (FrameLayout) findViewById(R.id.loginContainer);
                        isiDataContainer.setVisibility(VISIBLE);
                        IsiDataFragment isiDataFragment = new IsiDataFragment();
                        fragmentManager.beginTransaction()
                                .replace(R.id.loginContainer, isiDataFragment)
                                .commit();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
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
                    cek("video");

                    return true;
                case R.id.navigation_notifications:
                    cek("faq");

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
            case "video" :
//                Intent i = new  Intent(MenuActivity.this, MenuVideoActivity.class);
//                startActivity(i);
                VideoFragment videoFragment = new VideoFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.catalogueContainer, videoFragment)
                        .commit();
                break;
            case "faq" :
//
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
            FaqFragment faqFragment = new FaqFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.catalogueContainer, faqFragment)
                    .commit();
            return false;

        }else if (item.getItemId() == R.id.navigation3) {
            TermFragment termFragment = new TermFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.catalogueContainer, termFragment)
                    .commit();
            return false;

        }else if (item.getItemId() == R.id.navigation4) {
            PrivacyFragment privacyFragment = new PrivacyFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.catalogueContainer, privacyFragment)
                    .commit();
            return false;

        }else if (item.getItemId() == R.id.navigation5) {
            mAuth.signOut();
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
                @Override
                public void onResult(@NonNull Status status) {Intent intent = getIntent();
                    overridePendingTransition(0, 0);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(intent);
                }
            });
        }
        return false;
    }
}
