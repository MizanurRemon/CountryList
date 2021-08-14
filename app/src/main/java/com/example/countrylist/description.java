package com.example.countrylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class description extends AppCompatActivity implements View.OnClickListener {
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        backButton = (ImageButton) findViewById(R.id.backbuttonID);

        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.backbuttonID){
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}