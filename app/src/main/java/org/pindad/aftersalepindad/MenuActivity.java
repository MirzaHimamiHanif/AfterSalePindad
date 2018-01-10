package org.pindad.aftersalepindad;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fragmentManager = getSupportFragmentManager();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ImageFragment fragmentImage = new ImageFragment();
        fragmentManager.beginTransaction()
                .add(R.id.imageContainer, fragmentImage)
                .commit();
        CatalogueFragment catalogueFragment = new CatalogueFragment();
        fragmentManager.beginTransaction()
                .add(R.id.catalogueContainer, catalogueFragment)
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ImageFragment fragmentImage = new ImageFragment();
                    fragmentManager.beginTransaction()
                            .remove(fragmentImage)
                            .commit();
                    CatalogueFragment catalogueFragment = new CatalogueFragment();
                    fragmentManager.beginTransaction()
                            .remove(catalogueFragment)
                            .add(R.id.catalogueContainer, catalogueFragment)
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

}
