package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class InfoTechActivity extends AppCompatActivity {

    CardView firstSem, secondSem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tech);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("1st Year");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        firstSem = findViewById(R.id.firstSem);
        secondSem = findViewById(R.id.secondSem);
    }
}
