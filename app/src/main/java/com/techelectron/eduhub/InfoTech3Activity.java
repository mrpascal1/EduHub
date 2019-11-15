package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InfoTech3Activity extends AppCompatActivity {

    CardView fifthSem, sixthSem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tech3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("3rd Year");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fifthSem = findViewById(R.id.fifthSem);
        sixthSem = findViewById(R.id.sixthSem);

        fifthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoTech3Activity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        sixthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoTech3Activity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
