package com.techelectron.eduhub.QuestionPapers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.techelectron.eduhub.CommonWebActivity;
import com.techelectron.eduhub.R;

public class CsYear3Activity extends AppCompatActivity {

    CardView AICard, LINUXSERVERCard, STQACard, INSCard, AIOTCard, WSERVICESCard, GPCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_year3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("CS year 3");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        AICard = findViewById(R.id.AICard);
        LINUXSERVERCard = findViewById(R.id.LINUXSERVERCard);
        STQACard = findViewById(R.id.STQACard);
        INSCard = findViewById(R.id.INSCard);
        AIOTCard = findViewById(R.id.AIOTCard);
        WSERVICESCard = findViewById(R.id.WSERVICESCard);
        GPCard = findViewById(R.id.GPCard);

        AICard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(AICard, "nov2018AI", "april2019AI");
            }
        });

        LINUXSERVERCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(LINUXSERVERCard, "nov2018LINUXSERVER", "april2019LINUXSERVER");
            }
        });

        STQACard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(STQACard, "nov2018STQA", "april2019STQA");
            }
        });

        INSCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(INSCard, "nov2018INS", "april2019INS");
            }
        });

        AIOTCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(CsYear3Activity.this, AIOTCard);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.one_questionpaper_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.nov2018) {
                            Intent intent = new Intent(CsYear3Activity.this, CommonWebActivity.class);
                            intent.putExtra("YEAR", "nov2018AIOT");
                            startActivity(intent);
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });

        WSERVICESCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(WSERVICESCard, "nov2018WSERVICES", "april2019WSERVICES");
            }
        });

        GPCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(GPCard, "nov2018GP", "april2019GP");
            }
        });

    }

    public void yearPopup(View view, final String value1, final String value2){
        PopupMenu popup = new PopupMenu(CsYear3Activity.this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.two_questionpaper_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nov2018) {
                    Intent intent = new Intent(CsYear3Activity.this, CommonWebActivity.class);
                    intent.putExtra("YEAR", value1);
                    startActivity(intent);
                }else if (id == R.id.april2019){
                    Intent intent = new Intent(CsYear3Activity.this, CommonWebActivity.class);
                    intent.putExtra("YEAR", value2);
                    startActivity(intent);
                }
                return true;
            }
        });

        popup.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
