package com.example.informatikakesehatan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;
    CircleMenu circleMenu;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*---------------------Hooks------------------------*/
        circleMenu = findViewById(R.id.circle_menu);
        constraintLayout = findViewById(R.id.constraint_layout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);

        /*---------------------Toolbar------------------------*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu8);



        /*---------------------Navigation Drawer Set Color------------------------*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        /*---------------------Navigation Drawer Menu------------------------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        /*---------------------Circle Menu------------------------*/

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.menu2, R.mipmap.cancel)
                .addSubMenu(Color.parseColor("#83e85a"), R.mipmap.search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.alarm)
                .addSubMenu(Color.parseColor("#ff85ac"), R.mipmap.location2)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {

                        switch (index) {
                            case 0:
                                Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#F469a9"));

                                final Handler Shandler = new Handler();
                                Shandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MainActivity.this, Search.class);
                                        startActivity(intent);
                                    }
                                }, 2200);
                                break;

                            case 1:
                                Toast.makeText(MainActivity.this, "alarm", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#dcdf00"));

                                final Handler Ahandler = new Handler();
                                Ahandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MainActivity.this, MenuAlarm.class);
                                        startActivity(intent);
                                    }
                                }, 2200);
                                break;

                            case 2:
                                Toast.makeText(MainActivity.this, "location", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#ba53de"));

                                final Handler Ghandler = new Handler();
                                Ghandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MainActivity.this, GoogleMaps.class);
                                        startActivity(intent);
                                    }
                                }, 2200);
                                break;
                        }
                    }


                });
    }

    /*---------------------Button Navigation Drawer Menu------------------------*/
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent1 = new Intent(MainActivity.this, IntroductoryActivity.class);
                startActivity(intent1);
                break;

            case R.id.nav_about_us:
                Intent intent2 = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent2);
                break;

            case R.id.nav_share:
                Intent intent5 = new Intent(MainActivity.this, Share.class);
                startActivity(intent5);
                break;

            case R.id.nav_rate:
                Intent intent6 = new Intent(MainActivity.this, rateUs.class);
                startActivity(intent6);
                break;
        }
        return true;
    }
}
