package com.example.ya_beeprototypes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class browse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
    }
    public void viewListing(View view)
    {
        Intent intent = new Intent(browse.this, listing.class);
        startActivity(intent);
    }
}
