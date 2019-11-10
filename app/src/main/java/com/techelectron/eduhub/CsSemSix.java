package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CsSemSix extends AppCompatActivity {

    CardView WSNCard, CCCard, CFCard, IRCard, DIPCard, DATASCard, EHCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_sem_six);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("CS Sem 6");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        WSNCard = findViewById(R.id.WSNCard);
        CCCard = findViewById(R.id.CCCard);
        CFCard = findViewById(R.id.CFCard);
        IRCard = findViewById(R.id.IRCard);
        DIPCard = findViewById(R.id.DIPCard);
        DATASCard = findViewById(R.id.DATASCard);
        EHCard = findViewById(R.id.EHCard);

        WSNCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemSix.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        CCCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemSix.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        CFCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemSix.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        IRCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemSix.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        DIPCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemSix.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        DATASCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemSix.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        EHCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemSix.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
