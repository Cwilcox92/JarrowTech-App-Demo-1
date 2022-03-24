package com.example.hemphubdemo10;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigationView = findViewById(R.id.btm_nav);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id= menuItem.getItemId();

                if(id== R.id.home)
                { //now to make four fragments
                    HomeFragment hfragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,hfragment);
                    fragmentTransaction.commit();

                }
                if(id== R.id.transactions)
                { //now to make four fragments
                    TransactionsFragment tfragment = new TransactionsFragment();
                    FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,tfragment);
                    fragmentTransaction.commit();

                }
                if(id== R.id.scan)
                { //now to make four fragments
                    ScanFragment sfragment = new ScanFragment();
                    FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,sfragment);
                    fragmentTransaction.commit();

                }
                if(id== R.id.account)
                { //now to make four fragments
                    AccountFragment afragment = new AccountFragment();
                    FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,afragment);
                    fragmentTransaction.commit();

                }
                return true;
            }
        });
        //default fragment is the home fragment
        navigationView.setSelectedItemId(R.id.home);
    }
}