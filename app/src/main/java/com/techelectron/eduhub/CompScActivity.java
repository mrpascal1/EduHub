package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CompScActivity extends AppCompatActivity {

    CardView firstSem, secondSem, thirdSem, fourthSem, fifthSem, sixthSem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_sc);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Computer Science");
            actionBar.setElevation(0);
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        firstSem = findViewById(R.id.firstSem);
        secondSem = findViewById(R.id.secondSem);
        thirdSem = findViewById(R.id.thirdSem);
        fourthSem = findViewById(R.id.fourthSem);
        fifthSem = findViewById(R.id.fifthSem);
        sixthSem = findViewById(R.id.sixthSem);

        firstSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompScActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        secondSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompScActivity.this, CsSemTwo.class);
                startActivity(intent);
            }
        });

        thirdSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompScActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        fourthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompScActivity.this, CsSemFour.class);
                startActivity(intent);
            }
        });

        fifthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompScActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        sixthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompScActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
