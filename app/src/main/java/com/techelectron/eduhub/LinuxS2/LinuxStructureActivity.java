package com.techelectron.eduhub.LinuxS2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techelectron.eduhub.R;

import java.util.Objects;

public class LinuxStructureActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader, sixthHeader, seventhHeader, eightHeader, nineHeader;
    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow, seventhArrow, eightArrow, nineArrow;

    CardView LARCHCard, KERNELCard, SHELLCard, FSCard, BPCard, INITSCard, RUNLCard, SPCard, PMCard;

    LinearLayout LARCHLayout, KERNELLayout, SHELLLayout, FSLayout, BPLayout, INITSLayout, RUNLLayout, SPLayout, PMLayout;

    WebView LARCHWebView, KERNELWebView, SHELLWebView, FSWebView, BPWebView, INITSWebView, RUNLWebView, SPWebView, PMWebView;

    DatabaseReference databaseReference;
    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_structure);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Linux");
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

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);
        fourthArrow = findViewById(R.id.fourthArrow);
        fifthArrow = findViewById(R.id.fifthArrow);
        sixthArrow = findViewById(R.id.sixthArrow);
        seventhArrow = findViewById(R.id.seventhArrow);
        eightArrow = findViewById(R.id.eightArrow);
        nineArrow = findViewById(R.id.nineArrow);

        LARCHCard = findViewById(R.id.LARCHCard);
        KERNELCard = findViewById(R.id.KERNELCard);
        SHELLCard = findViewById(R.id.SHELLCard);
        FSCard = findViewById(R.id.FSCard);
        BPCard = findViewById(R.id.BPCard);
        INITSCard = findViewById(R.id.INITSCard);
        RUNLCard = findViewById(R.id.RUNLCard);
        SPCard = findViewById(R.id.SPCard);
        PMCard = findViewById(R.id.PMCard);

        LARCHLayout = findViewById(R.id.LARCHLayout);
        KERNELLayout = findViewById(R.id.KERNELLayout);
        SHELLLayout = findViewById(R.id.SHELLLayout);
        FSLayout = findViewById(R.id.FSLayout);
        BPLayout = findViewById(R.id.BPLayout);
        INITSLayout = findViewById(R.id.INITSLayout);
        RUNLLayout = findViewById(R.id.RUNLLayout);
        SPLayout = findViewById(R.id.SPLayout);
        PMLayout = findViewById(R.id.PMLayout);

        LARCHWebView = findViewById(R.id.LARCHWebView);
        KERNELWebView = findViewById(R.id.KERNELWebView);
        SHELLWebView = findViewById(R.id.SHELLWebView);
        FSWebView = findViewById(R.id.FSWebView);
        BPWebView = findViewById(R.id.BPWebView);
        INITSWebView = findViewById(R.id.INITSWebView);
        RUNLWebView = findViewById(R.id.RUNLWebView);
        SPWebView = findViewById(R.id.SPWebView);
        PMWebView = findViewById(R.id.PMWebView);

        initWebView(LARCHWebView);
        initWebView(KERNELWebView);
        initWebView(SHELLWebView);
        initWebView(FSWebView);
        initWebView(BPWebView);
        initWebView(INITSWebView);
        initWebView(RUNLWebView);
        initWebView(SPWebView);
        initWebView(PMWebView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadLARCH();
                loadKERNEL();
                loadSHELL();
                loadFS();
                loadBP();
                loadINITS();
                loadRUNL();
                loadSP();
                loadPM();
            }
        }).start();

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(LARCHLayout)){
                    setVisibility(LARCHLayout, VISIBLE);
                    animate(LARCHCard);
                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(LARCHLayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(KERNELLayout)){
                    setVisibility(KERNELLayout, VISIBLE);
                    animate(KERNELCard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(KERNELLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(SHELLLayout)){
                    setVisibility(SHELLLayout, VISIBLE);
                    animate(SHELLCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(SHELLLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(FSLayout)){
                    setVisibility(FSLayout, VISIBLE);
                    animate(FSCard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(FSLayout, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(BPLayout)){
                    setVisibility(BPLayout, VISIBLE);
                    animate(BPCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(BPLayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });

        sixthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(INITSLayout)){
                    setVisibility(INITSLayout, VISIBLE);
                    animate(INITSCard);
                    changeArrow(sixthArrow, 1);
                }else {
                    setVisibility(INITSLayout, GONE);
                    changeArrow(sixthArrow, 0);
                }
            }
        });

        seventhHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(RUNLLayout)){
                    setVisibility(RUNLLayout, VISIBLE);
                    animate(RUNLCard);
                    changeArrow(seventhArrow, 1);
                }else {
                    setVisibility(RUNLLayout, GONE);
                    changeArrow(seventhArrow, 0);
                }
            }
        });

        eightHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(SPLayout)){
                    setVisibility(SPLayout, VISIBLE);
                    animate(SPCard);
                    changeArrow(eightArrow, 1);
                }else {
                    setVisibility(SPLayout, GONE);
                    changeArrow(eightArrow, 0);
                }
            }
        });

        nineHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(PMLayout)){
                    setVisibility(PMLayout, VISIBLE);
                    animate(PMCard);
                    changeArrow(nineArrow, 1);
                }else {
                    setVisibility(PMLayout, GONE);
                    changeArrow(nineArrow, 0);
                }
            }
        });
    }

    public void loadLARCH(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String LARCH = Objects.requireNonNull(dataSnapshot.child("linux architecture").getValue()).toString();
                LARCHWebView.loadDataWithBaseURL(null, LARCH, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadKERNEL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String kernel = Objects.requireNonNull(dataSnapshot.child("kernel").getValue()).toString();
                KERNELWebView.loadDataWithBaseURL(null, kernel, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadSHELL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String shell = Objects.requireNonNull(dataSnapshot.child("shell").getValue()).toString();
                SHELLWebView.loadDataWithBaseURL(null, shell, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadFS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String fileSystem = Objects.requireNonNull(dataSnapshot.child("file system").getValue()).toString();
                FSWebView.loadDataWithBaseURL(null, fileSystem, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadBP(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String bootProcess = Objects.requireNonNull(dataSnapshot.child("boot process").getValue()).toString();
                BPWebView.loadDataWithBaseURL(null, bootProcess, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadINITS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String initScripts = Objects.requireNonNull(dataSnapshot.child("init scripts").getValue()).toString();
                INITSWebView.loadDataWithBaseURL(null, initScripts, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadRUNL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String runlevels = Objects.requireNonNull(dataSnapshot.child("runlevels").getValue()).toString();
                RUNLWebView.loadDataWithBaseURL(null, runlevels, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadSP(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String shutDownProcess = Objects.requireNonNull(dataSnapshot.child("shutdown process").getValue()).toString();
                SPWebView.loadDataWithBaseURL(null, shutDownProcess, MIME, ENCODING, null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadPM(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String packagingMethod = Objects.requireNonNull(dataSnapshot.child("packaging methods").getValue()).toString();
                PMWebView.loadDataWithBaseURL(null,packagingMethod, MIME, ENCODING, null);
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

    public void initWebView(WebView webView){
        webView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
