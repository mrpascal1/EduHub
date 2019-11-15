package com.techelectron.eduhub;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SyllabusActivity extends AppCompatActivity {

    ActionBar actionBar;

    CardView bscCS, bscIT;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Syllabus");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        bscCS = findViewById(R.id.bscCS);
        bscIT = findViewById(R.id.bscIT);

        bscCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                csPopup();
            }
        });

        bscIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(SyllabusActivity.this, InfoTechActivity.class);
                //startActivity(intent);
                itPopup();
            }
        });
    }

    public void csPopup() {
        PopupMenu popup = new PopupMenu(this, bscCS);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.year_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.year1) {
                    Intent intent = new Intent(SyllabusActivity.this, CompScActivity.class);
                    startActivity(intent);
                }else if (id == R.id.year2){
                    Intent intent = new Intent(SyllabusActivity.this, CompSc2Activity.class);
                    startActivity(intent);
                }else if (id == R.id.year3){
                    Intent intent = new Intent(SyllabusActivity.this, CompSc3Activity.class);
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
                    Intent intent = new Intent(SyllabusActivity.this, InfoTechActivity.class);
                    startActivity(intent);
                }else if (id == R.id.year2){
                    Intent intent = new Intent(SyllabusActivity.this, InfoTech2Activity.class);
                    startActivity(intent);
                }else if (id == R.id.year3){
                    Intent intent = new Intent(SyllabusActivity.this, InfoTech3Activity.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popup.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.aboutus){
            Intent intent = new Intent(SyllabusActivity.this, AboutUsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}