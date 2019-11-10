package com.techelectron.eduhub.GreenTech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.techelectron.eduhub.R;

public class GreenTechTheoryActivity extends AppCompatActivity {

    CardView chapter1, chapter2, chapter3, chapter4, chapter5, chapter6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_tech_theory);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Green Tech");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        chapter1 = findViewById(R.id.chapter1);
        chapter2 = findViewById(R.id.chapter2);
        chapter3 = findViewById(R.id.chapter3);
        chapter4 = findViewById(R.id.chapter4);
        chapter5 = findViewById(R.id.chapter5);
        chapter6 = findViewById(R.id.chapter6);

        chapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GreenTechTheoryActivity.this, GreenItOverviewActivity.class);
                startActivity(intent);
            }
        });

        chapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GreenTechTheoryActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        chapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GreenTechTheoryActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        chapter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GreenTechTheoryActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        chapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GreenTechTheoryActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        chapter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GreenTechTheoryActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
