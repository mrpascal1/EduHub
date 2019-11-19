package com.techelectron.eduhub.LinuxS2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.techelectron.eduhub.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LinuxIntro extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader,
            sixthHeader, seventhHeader, eightHeader, nineHeader, tenthHeader;

    CardView WILCard, HOLCard, PHILCard, CTYCard, TMLGYCard, DISTROCard, KvDCard, FOLCard, IMOLCard, IMQCard;

    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow,
            sixthArrow, seventhArrow, eightArrow, nineArrow, tenthArrow;

    TextView WILTv, HOLTv, PHILTv, CTYTv, TMLGYTv, DISTROTv, FOLTv, IMQTv;

    WebView TMLGYWebView, DISTROWebView, KvDWebView, IMOLWebView;
    WebSettings TMLGYWebSettings, DISTROWebSettings, KvDWebSettings, IMOLWebSettings;

    LinearLayout TMLGYLayout, DISTROLayout, KvDLayout, IMOLLayout;

    Typeface timesNewRoman;


    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_intro);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Introduction");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2");

        firstHeader = findViewById(R.id.firstHeader);
        secondHeader = findViewById(R.id.secondHeader);
        thirdHeader = findViewById(R.id.thirdHeader);
        fourthHeader = findViewById(R.id.fourthHeader);
        fifthHeader = findViewById(R.id.fifthHeader);
        sixthHeader = findViewById(R.id.sixthHeader);
        seventhHeader = findViewById(R.id.seventhHeader);
        eightHeader = findViewById(R.id.eightHeader);
        nineHeader = findViewById(R.id.nineHeader);
        tenthHeader = findViewById(R.id.tenthHeader);

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);
        fourthArrow = findViewById(R.id.fourthArrow);
        fifthArrow = findViewById(R.id.fifthArrow);
        sixthArrow = findViewById(R.id.sixthArrow);
        seventhArrow = findViewById(R.id.seventhArrow);
        eightArrow = findViewById(R.id.eightArrow);
        nineArrow = findViewById(R.id.nineArrow);
        tenthArrow = findViewById(R.id.tenthArrow);

        WILCard = findViewById(R.id.WILCard);
        HOLCard = findViewById(R.id.HOLCard);
        PHILCard = findViewById(R.id.PHILCard);
        CTYCard = findViewById(R.id.CTYCard);
        TMLGYCard = findViewById(R.id.TMLGYCard);
        DISTROCard = findViewById(R.id.DISTROCard);
        KvDCard = findViewById(R.id.KvDCard);
        FOLCard = findViewById(R.id.FOLCard);
        IMOLCard = findViewById(R.id.IMOLCard);
        IMQCard = findViewById(R.id.IMQCard);

        WILTv = findViewById(R.id.WILTv);
        HOLTv = findViewById(R.id.HOLTv);
        PHILTv = findViewById(R.id.PHILTv);
        CTYTv = findViewById(R.id.CTYTv);
        TMLGYTv = findViewById(R.id.TMLGYTv);
        DISTROTv = findViewById(R.id.DISTROTv);
        FOLTv = findViewById(R.id.FOLTv);
        IMQTv = findViewById(R.id.IMQTv);

        TMLGYLayout = findViewById(R.id.TMLGYLayout);
        DISTROLayout = findViewById(R.id.DISTROLayout);
        KvDLayout = findViewById(R.id.KvDLayout);
        IMOLLayout = findViewById(R.id.IMOLLayout);

        TMLGYWebView = findViewById(R.id.TMLGYWebView);
        DISTROWebView = findViewById(R.id.DISTROWebView);
        KvDWebView = findViewById(R.id.KvDWebView);
        IMOLWebView = findViewById(R.id.IMOLWebView);

        TMLGYWebSettings = TMLGYWebView.getSettings();
        TMLGYWebSettings.setJavaScriptEnabled(true);
        TMLGYWebView.loadUrl("file:///android_asset/linuxTable.html");

        DISTROWebSettings = DISTROWebView.getSettings();
        DISTROWebSettings.setJavaScriptEnabled(true);
        DISTROWebView.loadUrl("file:///android_asset/distro.html");

        KvDWebSettings = KvDWebView.getSettings();
        KvDWebSettings.setJavaScriptEnabled(true);
        KvDWebView.loadUrl("file:///android_asset/KernelvsDistro.html");

        IMOLWebSettings = IMOLWebView.getSettings();
        IMOLWebSettings.setJavaScriptEnabled(true);

        timesNewRoman = Typeface.createFromAsset(getAssets(), "times-new-roman.ttf");

        WILTv.setTypeface(timesNewRoman);
        HOLTv.setTypeface(timesNewRoman);
        PHILTv.setTypeface(timesNewRoman);
        CTYTv.setTypeface(timesNewRoman);
        TMLGYTv.setTypeface(timesNewRoman);
        DISTROTv.setTypeface(timesNewRoman);
        FOLTv.setTypeface(timesNewRoman);
        IMQTv.setTypeface(timesNewRoman);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(WILTv)){
                    setVisibility(WILTv, VISIBLE);

                    animate(WILCard);

                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(WILTv, GONE);
                    WILTv.setVisibility(View.GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(HOLTv)){
                    setVisibility(HOLTv, VISIBLE);

                    animate(HOLCard);

                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(HOLTv, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(PHILTv)){
                    setVisibility(PHILTv, VISIBLE);
                    animate(PHILCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(PHILTv, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(CTYTv)){
                    /*String text = "HI I am Community";
                    SpannableString content = new SpannableString(text);
                    UnderlineSpan underlineSpan = new UnderlineSpan();
                    content.setSpan(underlineSpan, 8, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    CTYTv.setText(content);*/
                    setVisibility(CTYTv, VISIBLE);
                    animate(CTYCard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(CTYTv, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(TMLGYLayout)){
                    setVisibility(TMLGYLayout, VISIBLE);
                    animate(TMLGYCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(TMLGYLayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });

        sixthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(DISTROLayout)){
                    setVisibility(DISTROLayout, VISIBLE);
                    animate(DISTROCard);
                    changeArrow(sixthArrow, 1);
                }else {
                    setVisibility(DISTROLayout, GONE);
                    changeArrow(sixthArrow, 0);
                }
            }
        });

        seventhHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(KvDLayout)){
                    setVisibility(KvDLayout, VISIBLE);
                    animate(KvDCard);
                    changeArrow(seventhArrow, 1);
                }else {
                    setVisibility(KvDLayout, GONE);
                    changeArrow(seventhArrow, 0);
                }
            }
        });

        eightHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(FOLTv)){
                    setVisibility(FOLTv, VISIBLE);
                    animate(FOLCard);
                    changeArrow(eightArrow, 1);
                }else {
                    setVisibility(FOLTv, GONE);
                    changeArrow(eightArrow, 0);
                }
            }
        });

        nineHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(IMOLLayout)){
                    setVisibility(IMOLLayout, VISIBLE);
                    animate(IMOLCard);
                    changeArrow(nineArrow, 1);
                }else {
                    setVisibility(IMOLLayout, GONE);
                    changeArrow(nineArrow, 0);
                }
            }
        });

        tenthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(IMQTv)){
                    setVisibility(IMQTv, VISIBLE);
                    animate(IMQCard);
                    changeArrow(tenthArrow, 1);
                }else {
                    setVisibility(IMQTv, GONE);
                    changeArrow(tenthArrow, 0);
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadWIL();
                loadHOL();
                loadPHIL();
                loadCTY();
                loadTMLGY();
                loadDISTRO();
                loadFOL();
                loadIMOL();
                loadIMQ();
            }
        }).start();
    }

    public void loadWIL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String WIL = Objects.requireNonNull(dataSnapshot.child("what is linux").getValue()).toString();
                WILTv.setText(WIL);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadHOL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String HOL = Objects.requireNonNull(dataSnapshot.child("history of linux").getValue()).toString();
                HOLTv.setText(HOL);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadPHIL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String philosophy = Objects.requireNonNull(dataSnapshot.child("philosophy").getValue()).toString();
                PHILTv.setText(philosophy);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadCTY(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String community = Objects.requireNonNull(dataSnapshot.child("community").getValue()).toString();
                CTYTv.setText(community);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadTMLGY(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String terminology = Objects.requireNonNull(dataSnapshot.child("terminology").getValue()).toString();
                TMLGYTv.setText(terminology);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadDISTRO(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String distribution = Objects.requireNonNull(dataSnapshot.child("distribution").getValue()).toString();
                DISTROTv.setText(distribution);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadFOL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String FOL = Objects.requireNonNull(dataSnapshot.child("features of linux").getValue()).toString();
                FOLTv.setText(FOL);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadIMOL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String IMOL = Objects.requireNonNull(dataSnapshot.child("imp of linux").getValue()).toString();
                IMOLWebView.loadDataWithBaseURL(null, IMOL, "text/html", "UTF-8", null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadIMQ(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String importants = Objects.requireNonNull(dataSnapshot.child("imp question").getValue()).toString();
                IMQTv.setText(importants);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void animate(CardView card) {
        card.setAlpha(0.0f);
        card.animate().translationY(card.getHeight()).alpha(1.0f).setListener(null);
    }

    public void changeArrow(TextView textView, int arrow){
        if (arrow == 1){
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.ic_arrow_up, 0);
        }else if (arrow == 0){
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.ic_arrow_down, 0);
        }
    }

    private boolean checkVisibility(TextView textView){
        boolean gone = textView.getVisibility() == View.GONE;
        return gone;
    }
    private boolean checkVisibility(View view){
        boolean gone = view.getVisibility() == View.GONE;
        return gone;
    }

    public void setVisibility(TextView textView, int visibility){
        textView.setVisibility(visibility);
    }
    public void setVisibility(View view, int visibility){
        view.setVisibility(visibility);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
