package com;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import com.bitleet.goldenwayit.R;


public class OurTeacher extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_teacher);
        getSupportActionBar().setTitle("Trainers");


        //statusbar color change
        getWindow().setStatusBarColor(ContextCompat.getColor(OurTeacher.this,R.color.black));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.custom)));
    }
}