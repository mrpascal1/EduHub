package com.techelectron.eduhub.GreenTech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techelectron.eduhub.R;

import java.util.Objects;

public class GreenItOverviewActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader, sixthHeader, seventhHeader, eightHeader, nineHeader;
    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow, seventhArrow, eightArrow, nineArrow;

    CardView INTROCard, ECSDCard, EIITCard, GRNINGITCard, RSOITCard, ENVSTBCard, STDECOCard, ESTCard, GWCard;

    LinearLayout INTROLayout, ECSDLayout, EIITLayout, GRNINGITLayout, RSOITLayout, ENVSTBLayout, STDECOLayout, ESTLayout, GWLayout;

    WebView INTROWebView, ECSDWebView, EIITWebView, GRNINGITWebView, RSOITWebView, ENVSTBWebView, STDECOWebView, ESTWebView, GWWebView;

    DatabaseReference databaseReference;

    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_it_overview);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Overview");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("Green Tech").child("GreenIT Overview");

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

        INTROCard = findViewById(R.id.INTROCard);
        ECSDCard = findViewById(R.id.ECSDCard);
        EIITCard = findViewById(R.id.EIITCard);
        GRNINGITCard = findViewById(R.id.GRNINGITCard);
        RSOITCard = findViewById(R.id.RSOITCard);
        ENVSTBCard = findViewById(R.id.ENVSTBCard);
        STDECOCard = findViewById(R.id.STDECOCard);
        ESTCard = findViewById(R.id.ESTCard);
        GWCard = findViewById(R.id.GWCard);

        INTROLayout = findViewById(R.id.INTROLayout);
        ECSDLayout = findViewById(R.id.ECSDLayout);
        EIITLayout = findViewById(R.id.EIITLayout);
        GRNINGITLayout = findViewById(R.id.GRNINGITLayout);
        RSOITLayout = findViewById(R.id.RSOITLayout);
        ENVSTBLayout = findViewById(R.id.ENVSTBLayout);
        STDECOLayout = findViewById(R.id.STDECOLayout);
        ESTLayout = findViewById(R.id.ESTLayout);
        GWLayout = findViewById(R.id.GWLayout);

        INTROWebView = findViewById(R.id.INTROWebView);
        ECSDWebView = findViewById(R.id.ECSDWebView);
        EIITWebView = findViewById(R.id.EIITWebView);
        GRNINGITWebView = findViewById(R.id.GRNINGITWebView);
        RSOITWebView = findViewById(R.id.RSOITWebView);
        ENVSTBWebView = findViewById(R.id.ENVSTBWebView);
        STDECOWebView = findViewById(R.id.STDECOWebView);
        ESTWebView = findViewById(R.id.ESTWebView);
        GWWebView = findViewById(R.id.GWWebView);

        initWebView(INTROWebView);
        initWebView(ECSDWebView);
        initWebView(EIITWebView);
        initWebView(GRNINGITWebView);
        initWebView(RSOITWebView);
        initWebView(ENVSTBWebView);
        initWebView(STDECOWebView);
        initWebView(ESTWebView);
        initWebView(GWWebView);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(INTROLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadINTRO();
                        }
                    }).start();
                    setVisibility(INTROLayout, VISIBLE);
                    animate(INTROCard);
                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(INTROLayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(ECSDLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadECSD();
                        }
                    }).start();
                    setVisibility(ECSDLayout, VISIBLE);
                    animate(ECSDCard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(ECSDLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(EIITLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadEIIT();
                        }
                    }).start();
                    setVisibility(EIITLayout, VISIBLE);
                    animate(EIITCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(EIITLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(GRNINGITLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadGRNINGIT();
                        }
                    }).start();
                    setVisibility(GRNINGITLayout, VISIBLE);
                    animate(GRNINGITCard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(GRNINGITLayout, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(RSOITLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadRSOIT();
                        }
                    }).start();
                    setVisibility(RSOITLayout, VISIBLE);
                    animate(RSOITCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(RSOITLayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });

        sixthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(ENVSTBLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadENVSTB();
                        }
                    }).start();
                    setVisibility(ENVSTBLayout, VISIBLE);
                    animate(ENVSTBCard);
                    changeArrow(sixthArrow, 1);
                }else {
                    setVisibility(ENVSTBLayout, GONE);
                    changeArrow(sixthArrow, 0);
                }
            }
        });

        seventhHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(STDECOLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadSTDECO();
                        }
                    }).start();
                    setVisibility(STDECOLayout, VISIBLE);
                    animate(STDECOCard);
                    changeArrow(seventhArrow, 1);
                }else {
                    setVisibility(STDECOLayout, GONE);
                    changeArrow(seventhArrow, 0);
                }
            }
        });

        eightHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(ESTLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadEST();
                        }
                    }).start();
                    setVisibility(ESTLayout, VISIBLE);
                    animate(ESTCard);
                    changeArrow(eightArrow, 1);
                }else {
                    setVisibility(ESTLayout, GONE);
                    changeArrow(eightArrow, 0);
                }
            }
        });

        nineHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(GWLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadGW();
                        }
                    }).start();
                    setVisibility(GWLayout, VISIBLE);
                    animate(GWCard);
                    changeArrow(nineArrow, 1);
                }else {
                    setVisibility(GWLayout, GONE);
                    changeArrow(nineArrow, 0);
                }
            }
        });
    }

    public void loadGW() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String GW = Objects.requireNonNull(dataSnapshot.child("Green Washing").getValue()).toString();
                checkSetContent(GW, GWWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadINTRO(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String INTRO = Objects.requireNonNull(dataSnapshot.child("introduction").getValue()).toString();
                checkSetContent(INTRO, INTROWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadECSD(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ECSD = Objects.requireNonNull(dataSnapshot.child("ECSD").getValue()).toString();
                checkSetContent(ECSD, ECSDWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadEIIT(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String EIIT = Objects.requireNonNull(dataSnapshot.child("env impact of IT").getValue()).toString();
                checkSetContent(EIIT, EIITWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadGRNINGIT(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String GRNINGIT = Objects.requireNonNull(dataSnapshot.child("greening IT").getValue()).toString();
                checkSetContent(GRNINGIT, GRNINGITWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadRSOIT(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String RSOIT = Objects.requireNonNull(dataSnapshot.child("RSOIT").getValue()).toString();
                checkSetContent(RSOIT, RSOITWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadENVSTB(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ENVSTB = Objects.requireNonNull(dataSnapshot.child("env sustainability").getValue()).toString();
                checkSetContent(ENVSTB, ENVSTBWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadSTDECO(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String STDECO = Objects.requireNonNull(dataSnapshot.child("standards and ecoLabeling").getValue()).toString();
                checkSetContent(STDECO, STDECOWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadEST(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String EST = Objects.requireNonNull(dataSnapshot.child("enterprise strategy").getValue()).toString();
                checkSetContent(EST, ESTWebView);
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

    public void checkSetContent(String topic, WebView webView){
        if (topic.equals("")){
            Toast.makeText(GreenItOverviewActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
        }else {
            webView.loadDataWithBaseURL(null, topic, MIME, ENCODING, null);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
