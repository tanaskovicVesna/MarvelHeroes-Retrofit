package com.menu.assignment.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ItemDataActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_data);

        //get intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");

        //get view
        textView = findViewById(R.id.text);
        imageView = findViewById(R.id.imageView1);

        //set data
        textView.setText(name);

        Glide.with(this)
                .load(image)
                .into(imageView);
    }
}