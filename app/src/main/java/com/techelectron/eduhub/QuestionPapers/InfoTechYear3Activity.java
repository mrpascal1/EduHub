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

public class InfoTechYear3Activity extends AppCompatActivity {

    CardView SPMCard, IOTCard, ITAICard, AWPCard, ITLSACard, EJCard, NGTCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tech_year3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("IT year 3");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        SPMCard = findViewById(R.id.SPMCard);
        IOTCard = findViewById(R.id.IOTCard);
        ITAICard = findViewById(R.id.ITAICard);
        AWPCard = findViewById(R.id.AWPCard);
        ITLSACard = findViewById(R.id.ITLSACard);
        EJCard = findViewById(R.id.EJCard);
        NGTCard = findViewById(R.id.NGTCard);

        SPMCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(SPMCard, "nov2018SPM", "april2019SPM");
            }
        });

        IOTCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(IOTCard, "nov2018IOT", "april2019IOT");
            }
        });

        ITAICard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(ITAICard, "nov2018ITAI", "april2019ITAI");
            }
        });

        AWPCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(AWPCard, "nov2018AWP", "april2019AWP");
            }
        });

        ITLSACard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(ITLSACard, "nov2018ITLSA", "april2019ITLSA");
            }
        });

        EJCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(EJCard, "nov2018EJ", "april2019EJ");
            }
        });

        NGTCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(NGTCard, "nov2018NGT", "april2019NGT");
            }
        });
    }

    public void yearPopup(View view, final String value1, final String value2){
        PopupMenu popup = new PopupMenu(InfoTechYear3Activity.this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.two_questionpaper_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nov2018) {
                    Intent intent = new Intent(InfoTechYear3Activity.this, CommonWebActivity.class);
                    intent.putExtra("YEAR", value1);
                    startActivity(intent);
                }else if (id == R.id.april2019){
                    Intent intent = new Intent(InfoTechYear3Activity.this, CommonWebActivity.class);
                    intent.putExtra("YEAR", value2);
                    startActivity(intent);
                }
                return true;
            }
        });

        popup.show();
    }
}
