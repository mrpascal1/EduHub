package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    Uri instaUri, twitterUri, linkedInUri, facebookUri;

    LinearLayout instaLayout, twitterLayout, linkedInLayout, facebookLayout;

    TextView versionInfo;
    String versionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("About us");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        instaLayout = findViewById(R.id.instaLayout);
        twitterLayout = findViewById(R.id.twitterLayout);
        linkedInLayout = findViewById(R.id.linkedInLayout);
        facebookLayout = findViewById(R.id.facebookLayout);

        instaUri = Uri.parse("http://instagram.com/_u/_eduhub_");
        twitterUri = Uri.parse("http://instagram.com/_u/_eduhub_");
        linkedInUri = Uri.parse("http://linkedin.com/company/techelectron");
        facebookUri = Uri.parse("http://facebook.com/techelectron-102477581190208");

        versionInfo = findViewById(R.id.versionInfo);

        versionName = BuildConfig.VERSION_NAME;
        versionInfo.setText("Version " + versionName);

        instaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, instaUri);
                intent.setPackage("com.instagram.android");
                try{
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_eduhub_")));
                }
            }
        });

        /*twitterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        linkedInLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, linkedInUri);
                intent.setPackage("com.linkedin.android");
                try{
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://linkedin.com/company/techelectron")));
                }
            }
        });

        facebookLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, facebookUri);
                intent.setPackage("com.facebook.katana");
                try{
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/techelectron-102477581190208")));
                }
            }
        });
    }
}
