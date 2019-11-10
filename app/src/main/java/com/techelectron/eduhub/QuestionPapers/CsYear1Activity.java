package com.techelectron.eduhub.QuestionPapers;

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

public class CsYear1Activity extends AppCompatActivity {

    CardView CODCard, PYTHONCard, FOSSCard, DBMSCard, MATHSCard, STATSCard, SSDCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_year1);

        CODCard = findViewById(R.id.CODCard);
        PYTHONCard = findViewById(R.id.PYTHONCard);
        FOSSCard = findViewById(R.id.FOSSCard);
        DBMSCard = findViewById(R.id.DBMSCard);
        MATHSCard = findViewById(R.id.MATHSCard);
        STATSCard = findViewById(R.id.STATSCard);
        SSDCard = findViewById(R.id.SSDCard);

        CODCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(CODCard, "nov2018COD", "april2019COD");
            }
        });

        PYTHONCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPopup(PYTHONCard, "nov2018PYTHON", "april2019PYTHON");
            }
        });
    }

    public void csPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.year_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nov2018) {
                    Intent intent = new Intent(CsYear1Activity.this, CommonWebActivity.class);
                    startActivity(intent);
                }else if (id == R.id.april2019){
                    Intent intent = new Intent(CsYear1Activity.this, CommonWebActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popup.show();
    }

    public void yearPopup(View view, final String value1, final String value2){
        PopupMenu popup = new PopupMenu(CsYear1Activity.this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.two_questionpaper_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nov2018) {
                    Intent intent = new Intent(CsYear1Activity.this, CommonWebActivity.class);
                    intent.putExtra("YEAR", value1);
                    startActivity(intent);
                }else if (id == R.id.april2019){
                    Intent intent = new Intent(CsYear1Activity.this, CommonWebActivity.class);
                    intent.putExtra("YEAR", value2);
                    startActivity(intent);
                }
                return true;
            }
        });

        popup.show();
    }

}
