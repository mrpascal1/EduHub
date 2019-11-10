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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techelectron.eduhub.GreenTech.GreenItOverviewActivity;
import com.techelectron.eduhub.R;

import java.util.Objects;

public class LinuxCommandLineActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader, sixthHeader;
    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow;

    CardView CLIMODECard, SHELLSCard, BCMDSCard, GPUTILSCard, USERMGCard, ENVVARCard;

    LinearLayout CLIMODELayout, SHELLSLayout, BCMDSLayout, GPUTILSLayout, USERMGLayout, ENVVARLayout;

    WebView CLIMODEWebView, SHELLSWebView, BCMDSWebView, GPUTILSWebView, USERMGWebView, ENVVARWebView;

    DatabaseReference databaseReference;

    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_command_line);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Linux");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2").child("Command Line");

        firstHeader = findViewById(R.id.firstHeader);
        secondHeader = findViewById(R.id.secondHeader);
        thirdHeader = findViewById(R.id.thirdHeader);
        fourthHeader = findViewById(R.id.fourthHeader);
        fifthHeader = findViewById(R.id.fifthHeader);
        sixthHeader = findViewById(R.id.sixthHeader);

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);
        fourthArrow = findViewById(R.id.fourthArrow);
        fifthArrow = findViewById(R.id.fifthArrow);
        sixthArrow = findViewById(R.id.sixthArrow);

        CLIMODECard = findViewById(R.id.CLIMODECard);
        SHELLSCard = findViewById(R.id.SHELLSCard);
        BCMDSCard = findViewById(R.id.BCMDSCard);
        GPUTILSCard = findViewById(R.id.GPUTILSCard);
        USERMGCard = findViewById(R.id.USERMGCard);
        ENVVARCard = findViewById(R.id.ENVVARCard);

        CLIMODELayout = findViewById(R.id.CLIMODELayout);
        SHELLSLayout = findViewById(R.id.SHELLSLayout);
        BCMDSLayout = findViewById(R.id.BCMDSLayout);
        GPUTILSLayout = findViewById(R.id.GPUTILSLayout);
        USERMGLayout = findViewById(R.id.USERMGLayout);
        ENVVARLayout = findViewById(R.id.ENVVARLayout);

        CLIMODEWebView = findViewById(R.id.CLIMODEWebView);
        SHELLSWebView = findViewById(R.id.SHELLSWebView);
        BCMDSWebView = findViewById(R.id.BCMDSWebView);
        GPUTILSWebView = findViewById(R.id.GPUTILSWebView);
        USERMGWebView = findViewById(R.id.USERMGWebView);
        ENVVARWebView = findViewById(R.id.ENVVARWebView);

        initWebView(CLIMODEWebView);
        initWebView(SHELLSWebView);
        initWebView(BCMDSWebView);
        initWebView(GPUTILSWebView);
        initWebView(USERMGWebView);
        initWebView(ENVVARWebView);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(CLIMODELayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadCLIMODE();
                        }
                    }).start();
                    setVisibility(CLIMODELayout, VISIBLE);
                    animate(CLIMODECard);
                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(CLIMODELayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(SHELLSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadSHELLS();
                        }
                    }).start();
                    setVisibility(SHELLSLayout, VISIBLE);
                    animate(SHELLSCard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(SHELLSLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(BCMDSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadBCMDS();
                        }
                    }).start();
                    setVisibility(BCMDSLayout, VISIBLE);
                    animate(BCMDSCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(BCMDSLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(GPUTILSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadGPUTILS();
                        }
                    }).start();
                    setVisibility(GPUTILSLayout, VISIBLE);
                    animate(GPUTILSCard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(GPUTILSLayout, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(USERMGLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadUSERMG();
                        }
                    }).start();
                    setVisibility(USERMGLayout, VISIBLE);
                    animate(USERMGCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(USERMGLayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });

        sixthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(ENVVARLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadENVVAR();
                        }
                    }).start();
                    setVisibility(ENVVARLayout, VISIBLE);
                    animate(ENVVARCard);
                    changeArrow(sixthArrow, 1);
                }else {
                    setVisibility(ENVVARLayout, GONE);
                    changeArrow(sixthArrow, 0);
                }
            }
        });
    }

    public void loadCLIMODE(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String CLIMODE = Objects.requireNonNull(dataSnapshot.child("cli mode options").getValue()).toString();
                checkSetContent(CLIMODE, CLIMODEWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadSHELLS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String SHELLS = Objects.requireNonNull(dataSnapshot.child("shells").getValue()).toString();
                checkSetContent(SHELLS, SHELLSWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadBCMDS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String basicCommands = Objects.requireNonNull(dataSnapshot.child("basic commands").getValue()).toString();
                checkSetContent(basicCommands, BCMDSWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadGPUTILS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String GPUTILS = Objects.requireNonNull(dataSnapshot.child("general purpose utils").getValue()).toString();
                checkSetContent(GPUTILS, GPUTILSWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadUSERMG(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String USERMG = Objects.requireNonNull(dataSnapshot.child("user management").getValue()).toString();
                checkSetContent(USERMG, USERMGWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadENVVAR(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String environmentVar = Objects.requireNonNull(dataSnapshot.child("environment variables").getValue()).toString();
                checkSetContent(environmentVar, ENVVARWebView);
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
            Toast.makeText(LinuxCommandLineActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
        }else {
            webView.loadDataWithBaseURL(null, topic, MIME, ENCODING, null);
        }
    }
}
