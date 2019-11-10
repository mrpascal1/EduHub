package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.techelectron.eduhub.QuestionPapers.CsYear1Activity;
import com.techelectron.eduhub.QuestionPapers.CsYear2Activity;
import com.techelectron.eduhub.QuestionPapers.CsYear3Activity;
import com.techelectron.eduhub.QuestionPapers.InfoTechYear1Activity;
import com.techelectron.eduhub.QuestionPapers.InfoTechYear2Activity;
import com.techelectron.eduhub.QuestionPapers.InfoTechYear3Activity;

public class QuestionPaperActivity extends AppCompatActivity {

    CardView bscCS, bscIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_paper);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Question Papers");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        bscCS = findViewById(R.id.bscCS);
        bscIT = findViewById(R.id.bscIT);

        bscCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionPaperActivity.this, CsYear3Activity.class);
                startActivity(intent);
            }
        });

        bscIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionPaperActivity.this, InfoTechYear3Activity.class);
                startActivity(intent);
            }
        });
    }
/*
    public void csPopup() {
        PopupMenu popup = new PopupMenu(this, bscCS);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.year_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.year1) {
                    Intent intent = new Intent(QuestionPaperActivity.this, CsYear1Activity.class);
                    startActivity(intent);
                }else if (id == R.id.year2){
                    Intent intent = new Intent(QuestionPaperActivity.this, CsYear2Activity.class);
                    startActivity(intent);
                }else if (id == R.id.year3){
                    Intent intent = new Intent(QuestionPaperActivity.this, CsYear3Activity.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popup.show();
    }

    public void itPopup() {
        PopupMenu popup = new PopupMenu(this, bscIT);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.year_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.year1) {
                    Intent intent = new Intent(QuestionPaperActivity.this, InfoTechYear1Activity.class);
                    startActivity(intent);
                }else if (id == R.id.year2){
                    Intent intent = new Intent(QuestionPaperActivity.this, InfoTechYear2Activity.class);
                    startActivity(intent);
                }else if (id == R.id.year3){
                    Intent intent = new Intent(QuestionPaperActivity.this, InfoTechYear3Activity.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popup.show();
    }*/
}
