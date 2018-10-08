package com.example.myati.mybusinesscard;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

public class NewsDetailsActivity extends AppCompatActivity {
    ImageView imageDetails;
    TextView titleDetails;
    TextView textDetails;
    TextView dateDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        imageDetails = findViewById(R.id.main_backdrop);
        titleDetails = findViewById(R.id.title_details);
        textDetails = findViewById(R.id.text_details);
        dateDetails = findViewById(R.id.date_details);

        Intent intent = getIntent();

        setDataFromIntent(intent);
        setCategoryTitle(intent);


    }

    private void setDataFromIntent(Intent intent) {
        titleDetails.setText(intent.getStringExtra("TITLE_KEY"));
        textDetails.setText(intent.getStringExtra("TEXT_KEY"));
        dateDetails.setText(intent.getStringExtra("DATE_KEY"));
        String imageUrl = intent.getStringExtra("IMGURL_KEY");
        Glide.with(this).load(imageUrl).into(imageDetails);


    }

    private void setCategoryTitle(Intent intent) {
        String category = intent.getStringExtra("CATEGORY_KEY");
        setTitle(category);
    }


}
