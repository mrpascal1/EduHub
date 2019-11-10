package com.techelectron.eduhub.QuestionPapers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.techelectron.eduhub.R;

public class InfoTechYear3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tech_year3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("IT year 3");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }
    }
}
