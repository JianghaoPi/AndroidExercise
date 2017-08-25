package com.mobile.test.testmonitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mobile.test.testmonitor.fragment.FragmentFile;
import com.mobile.test.testmonitor.fragment.FragmentHome;


public class MainActivity extends AppCompatActivity {
    private FragmentFile fragmentFile;
    private FragmentHome fragmentHome;
    private FragmentManager manager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction transaction1 = manager.beginTransaction();
                    transaction1.replace(R.id.content, fragmentHome);
                    transaction1.commit();
                    return true;
                case R.id.navigation_file:
                    FragmentTransaction transaction2 = manager.beginTransaction();
                    transaction2.replace(R.id.content, fragmentFile);
                    transaction2.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        fragmentFile = new FragmentFile();
        fragmentHome = new FragmentHome();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content, fragmentHome);
        transaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
