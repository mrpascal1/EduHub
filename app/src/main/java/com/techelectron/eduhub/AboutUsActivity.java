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
import android.widget.Toast;

public class AboutUsActivity extends AppCompatActivity {

    Uri instaUri, twitterUri, linkedInUri, facebookUri;

    LinearLayout aboutLayout, instaLayout, twitterLayout, linkedInLayout, facebookLayout, shareLayout, aboutTv;

    TextView versionInfo;
    String versionName;

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("About us");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            //actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        aboutLayout = findViewById(R.id.aboutLayout);
        instaLayout = findViewById(R.id.instaLayout);
        twitterLayout = findViewById(R.id.twitterLayout);
        linkedInLayout = findViewById(R.id.linkedInLayout);
        facebookLayout = findViewById(R.id.facebookLayout);
        shareLayout = findViewById(R.id.shareLayout);

        aboutTv = findViewById(R.id.aboutTv);

        instaUri = Uri.parse("http://instagram.com/_u/_eduhub_");
        twitterUri = Uri.parse("http://twitter.com/techelectron5");
        linkedInUri = Uri.parse("http://linkedin.com/company/techelectron");
        facebookUri = Uri.parse("http://facebook.com/techelectron-102477581190208");

        versionInfo = findViewById(R.id.versionInfo);

        versionName = BuildConfig.VERSION_NAME;
        versionInfo.setText("Version " + versionName);

        aboutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(aboutTv)){
                    setVisibility(aboutTv, VISIBLE);
                }else {
                    setVisibility(aboutTv, GONE);
                }
            }
        });

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

        twitterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, twitterUri);
                intent.setPackage("com.twitter.android");
                try{
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/techelectron5")));
                }
            }
        });

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

        shareLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "EduHub");
                    String shareMessage = "\nI invite you to learn with me on eduhub\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Choose one"));
                }catch (Exception e){
                    Toast.makeText(AboutUsActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkVisibility(View view){
        boolean gone = view.getVisibility() == View.GONE;
        return gone;
    }

    public void setVisibility(View view, int visibility){
        view.setVisibility(visibility);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
