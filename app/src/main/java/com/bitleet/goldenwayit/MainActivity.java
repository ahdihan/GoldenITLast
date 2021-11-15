package com.bitleet.goldenwayit;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.AboutUs;
import com.OurTeacher;
import com.SliderAdapter;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.webViewActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    SliderView sliderView;
    int[] images = {R.drawable.golden_background,
            R.drawable.golden_background2,
            R.drawable.golden_background3,
            R.drawable.golden_background4,
            R.drawable.golden_background5};

    private MenuItem admission;
    private Button btn1, btn2, btn3;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    String[] urls = new String[8];

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Golden Way Technical Institute");


        //status bar color change
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.custom)));

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        drawerLayout = findViewById(R.id.drawerId);

        NavigationView navigationView = findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        admission = findViewById(R.id.admissionId);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);


        urls[0] = "https://goldenwayit.com/courses/?fbclid=IwAR3QELs8vBPX9H_tST79-m30lwPQY1YtHT851AYqhFJqM0plw_jm_CwKSKs";
        urls[1] = "https://goldenwayit.com/admission/?fbclid=IwAR2_zsHOhH93Rcu0poBt_3uk9vPjWZ9M6ZInCuzTHFSl4Ek1uy8APVqIqvM";
        urls[2] = "https://goldenwayit.com/courses/?fbclid=IwAR3QELs8vBPX9H_tST79-m30lwPQY1YtHT851AYqhFJqM0plw_jm_CwKSKs";
        urls[3] = "https://goldenwayit.com/notice/?fbclid=IwAR2-HRUhpFZrnC4oJaxQI6fggi39iTvOiLI10A15npMY3Ccw5G_g6gR-KxY";
        urls[4] = "https://goldenwayit.com/exam-result/?fbclid=IwAR15B2emt8PvLybf78kR9kYbOXFZWvQORg2gg7UMy_n9UckA1wusw3EmLd4";
        urls[5] = "https://goldenwayit.com/certificate/?fbclid=IwAR3lJ8SQnYl-kv4cGWqqZqbuVfQt1DzuQTzoeaHj46Lanh1A_m9BTWSgvsc";
        urls[6] = "https://goldenwayit.com/account/";
        //urls[7] = "http://goldenwayit.com/contact?fbclid=IwAR2lwhafbZomtejo6e6VNcM7ao-SZhw86UGGSdzgeptlTicjAr13S5HcbGk";
        urls[7] = "https://github.com/";

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, webViewActivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Swipe Down for Refresh", Toast.LENGTH_LONG).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, webViewActivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Swipe Down for Refresh", Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, webViewActivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Swipe Down for Refresh", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent;

        if (item.getItemId() == R.id.homeMenuId) {

            intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.aboutUsId) {

            intent = new Intent(MainActivity.this, AboutUs.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.ourTeacherId) {

            intent = new Intent(this, OurTeacher.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.contactUsId) {

            intent = new Intent(MainActivity.this, webViewActivity.class);
            intent.putExtra("links",urls[7]);
            startActivity(intent);

        } else if (item.getItemId() == R.id.admissionId) {

            intent = new Intent(MainActivity.this, webViewActivity.class);
            intent.putExtra("links",urls[1]);
            startActivity(intent);

        } else if (item.getItemId() == R.id.coursesId) {

            intent = new Intent(MainActivity.this, webViewActivity.class);
            intent.putExtra("links",urls[2]);
            startActivity(intent);


        } else if (item.getItemId() == R.id.noticeId) {

            intent = new Intent(MainActivity.this, webViewActivity.class);
            intent.putExtra("links",urls[3]);
            startActivity(intent);


        } else if (item.getItemId() == R.id.resultId) {

            intent = new Intent(MainActivity.this, webViewActivity.class);
            intent.putExtra("links",urls[4]);
            startActivity(intent);

        } else if (item.getItemId() == R.id.certificateId) {

            intent = new Intent(MainActivity.this, webViewActivity.class);
            intent.putExtra("links",urls[5]);
            startActivity(intent);

        } else if (item.getItemId() == R.id.loginId) {

            intent = new Intent(MainActivity.this, webViewActivity.class);
            intent.putExtra("links", urls[6]);

        }
        return false;
    }
    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Exit Application", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}