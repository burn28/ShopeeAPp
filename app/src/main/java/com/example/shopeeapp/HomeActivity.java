package com.example.shopeeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.shopeeapp.fragment.DonateFragment;
import com.example.shopeeapp.fragment.FeedFragment;
import com.example.shopeeapp.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemReselectedListener(navItemSelectListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeedFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemReselectedListener navItemSelectListener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull @NotNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectFragment = new FeedFragment();
//                    bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
                    break;
                case R.id.nav_donate:
                    selectFragment = new DonateFragment();
                    break;
                case R.id.nav_profile:
                    SharedPreferences.Editor editor = getSharedPreferences("PREF", MODE_PRIVATE).edit();
                    editor.putString("profileid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    editor.apply();
                    selectFragment = new ProfileFragment();
                    break;
            }
            if(selectFragment!=null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();
            }
        }
    };
}