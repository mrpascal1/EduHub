package com.techelectron.eduhub.GreenTech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.techelectron.eduhub.PythonCourse.PythonCourseIntro;
import com.techelectron.eduhub.R;

public class GreenTechTheoryActivity extends AppCompatActivity {

    CardView chapter1, chapter2, chapter3, chapter4, chapter5, chapter6, chapter7, chapter8, chapter9, chapter10, chapter11, chapter12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_tech_theory);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Green Tech");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        chapter1 = findViewById(R.id.chapter1);
        chapter2 = findViewById(R.id.chapter2);
        chapter3 = findViewById(R.id.chapter3);
        chapter4 = findViewById(R.id.chapter4);
        chapter5 = findViewById(R.id.chapter5);
        chapter6 = findViewById(R.id.chapter6);
        chapter7 = findViewById(R.id.chapter7);
        chapter8 = findViewById(R.id.chapter8);
        chapter9 = findViewById(R.id.chapter9);
        chapter10 = findViewById(R.id.chapter10);
        chapter11 = findViewById(R.id.chapter11);
        chapter12 = findViewById(R.id.chapter12);

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
                setAndOpenContent("Green Devices and Hardware");
            }
        });

        chapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Green Software");
            }
        });

        chapter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Sustainable Software Development");
            }
        });

        chapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Green Data Centres");
            }
        });

        chapter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Green Data Storage");
            }
        });

        chapter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Green Networks and Communications");
            }
        });

        chapter8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Enterprise Green IT Strategy");
            }
        });

        chapter9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Sustainable Information Systems and Green Metrics");
            }
        });

        chapter10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Enterprise Green IT Readiness");
            }
        });

        chapter11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Sustainable IT Services");
            }
        });

        chapter12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Role of IT");
            }
        });
    }

    public void setAndOpenContent(String topic){
        Intent intent = new Intent(GreenTechTheoryActivity.this, GreenTechCommonActivity.class);
        intent.putExtra("Green Tech", topic);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
