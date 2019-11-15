package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //private ArrayList<Integer> phoneNumberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Drawable res = getResources().getDrawable(R.drawable.seal_of_approval);
        imageView.setImageDrawable(res);

    }


}
