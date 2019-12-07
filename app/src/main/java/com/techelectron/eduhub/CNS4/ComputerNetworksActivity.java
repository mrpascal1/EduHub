package com.techelectron.eduhub.CNS4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.techelectron.eduhub.GreenTech.GreenTechCommonActivity;
import com.techelectron.eduhub.GreenTech.GreenTechTheoryActivity;
import com.techelectron.eduhub.R;

public class ComputerNetworksActivity extends AppCompatActivity {

    CardView cnChapter1, cnChapter2, cnChapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_networks);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Computer Networks");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cnChapter1 = findViewById(R.id.CNchapter1);
        cnChapter2 = findViewById(R.id.CNchapter2);
        cnChapter3 = findViewById(R.id.CNchapter3);

        cnChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Network Models");
            }
        });

        cnChapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Physical and Data link layer");
            }
        });

        cnChapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Network and Transport layer");
            }
        });
    }

    public void setAndOpenContent(String topic){
        Intent intent = new Intent(ComputerNetworksActivity.this, ComputerNetworksCommonActivity.class);
        intent.putExtra("Computer Networks", topic);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
