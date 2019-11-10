package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.techelectron.eduhub.GreenTech.GreenTechTheoryActivity;

public class CsSemTwo extends AppCompatActivity {

    CardView cProg, pyProg, linuxSem2, dsSem2, gtSem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_sem_two);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("CS Sem 2");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        cProg = findViewById(R.id.cProg);
        pyProg = findViewById(R.id.pyProg);
        linuxSem2 = findViewById(R.id.linuxSem2);
        dsSem2 = findViewById(R.id.dsSem2);
        gtSem2 = findViewById(R.id.gtSem2);

        cProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemTwo.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        pyProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CsSemTwo.this, PythonActivity.class);
                startActivity(intent);
            }
        });

        linuxSem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CsSemTwo.this, LinuxSem2Activity.class);
                startActivity(intent);
            }
        });

        dsSem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CsSemTwo.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        gtSem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CsSemTwo.this, GreenTechTheoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
