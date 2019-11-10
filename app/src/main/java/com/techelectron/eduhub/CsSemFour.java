package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CsSemFour extends AppCompatActivity {

    CardView foa, advJava, compNetworks, dotNet, androidDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_sem_four);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("CS Sem 4");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        foa = findViewById(R.id.foa);
        advJava = findViewById(R.id.advJava);
        compNetworks = findViewById(R.id.compNetworks);
        dotNet = findViewById(R.id.dotNet);
        androidDev = findViewById(R.id.androidDev);

        foa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemFour.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
