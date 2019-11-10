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
import com.techelectron.eduhub.R;

import java.util.Objects;

public class LinuxBasicShellScriptActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader, sixthHeader, seventhHeader, eightHeader;
    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow, seventhArrow, eightArrow;

    CardView FACCard, MFCard, SEDCard, AWKCard, FMUCard, SMCard, BECard, CASECard;

    LinearLayout FACLayout, MFLayout, SEDLayout, AWKLayout, FMULayout, SMLayout, BELayout, CASELayout;

    WebView FACWebView, MFWebView, SEDWebView, AWKWebView, FMUWebView, SMWebView, BEWebView, CASEWebView;

    DatabaseReference databaseReference;
    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_basic_shell_script);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Linux");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2").child("Basic Shell Scripting");

        firstHeader = findViewById(R.id.firstHeader);
        secondHeader = findViewById(R.id.secondHeader);
        thirdHeader = findViewById(R.id.thirdHeader);
        fourthHeader = findViewById(R.id.fourthHeader);
        fifthHeader = findViewById(R.id.fifthHeader);
        sixthHeader = findViewById(R.id.sixthHeader);
        seventhHeader = findViewById(R.id.seventhHeader);
        eightHeader = findViewById(R.id.eightHeader);

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);
        fourthArrow = findViewById(R.id.fourthArrow);
        fifthArrow = findViewById(R.id.fifthArrow);
        sixthArrow = findViewById(R.id.sixthArrow);
        seventhArrow = findViewById(R.id.seventhArrow);
        eightArrow = findViewById(R.id.eightArrow);

        FACCard = findViewById(R.id.FACCard);
        MFCard = findViewById(R.id.MFCard);
        SEDCard = findViewById(R.id.SEDCard);
        AWKCard = findViewById(R.id.AWKCard);
        FMUCard = findViewById(R.id.FMUCard);
        SMCard = findViewById(R.id.SMCard);
        BECard = findViewById(R.id.BECard);
        CASECard = findViewById(R.id.CASECard);

        FACLayout = findViewById(R.id.FACLayout);
        MFLayout = findViewById(R.id.MFLayout);
        SEDLayout = findViewById(R.id.SEDLayout);
        AWKLayout = findViewById(R.id.AWKLayout);
        FMULayout = findViewById(R.id.FMULayout);
        SMLayout = findViewById(R.id.SMLayout);
        BELayout = findViewById(R.id.BELayout);
        CASELayout = findViewById(R.id.CASELayout);

        FACWebView = findViewById(R.id.FACWebView);
        MFWebView = findViewById(R.id.MFWebView);
        SEDWebView = findViewById(R.id.SEDWebView);
        AWKWebView = findViewById(R.id.AWKWebView);
        FMUWebView = findViewById(R.id.FMUWebView);
        SMWebView = findViewById(R.id.SMWebView);
        BEWebView = findViewById(R.id.BEWebView);
        CASEWebView = findViewById(R.id.CASEWebView);

        initWebView(FACWebView);
        initWebView(MFWebView);
        initWebView(SEDWebView);
        initWebView(AWKWebView);
        initWebView(FMUWebView);
        initWebView(SMWebView);
        initWebView(BEWebView);
        initWebView(CASEWebView);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(FACLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadFAC();
                        }
                    }).start();
                    setVisibility(FACLayout, VISIBLE);
                    animate(FACCard);
                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(FACLayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(MFLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadMF();
                        }
                    }).start();
                    setVisibility(MFLayout, VISIBLE);
                    animate(MFCard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(MFLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(SEDLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadSED();
                        }
                    }).start();
                    setVisibility(SEDLayout, VISIBLE);
                    animate(SEDCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(SEDLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(AWKLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadAWK();
                        }
                    }).start();
                    setVisibility(AWKLayout, VISIBLE);
                    animate(AWKCard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(AWKLayout, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(FMULayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadFMU();
                        }
                    }).start();
                    setVisibility(FMULayout, VISIBLE);
                    animate(FMUCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(FMULayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });

        sixthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(SMLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadSM();
                        }
                    }).start();
                    setVisibility(SMLayout, VISIBLE);
                    animate(SMCard);
                    changeArrow(sixthArrow, 1);
                }else {
                    setVisibility(SMLayout, GONE);
                    changeArrow(sixthArrow, 0);
                }
            }
        });

        seventhHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(BELayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadBE();
                        }
                    }).start();
                    setVisibility(BELayout, VISIBLE);
                    animate(BECard);
                    changeArrow(seventhArrow, 1);
                }else {
                    setVisibility(BELayout, GONE);
                    changeArrow(seventhArrow, 0);
                }
            }
        });

        eightHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(CASELayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadCASE();
                        }
                    }).start();
                    setVisibility(CASELayout, VISIBLE);
                    animate(CASECard);
                    changeArrow(eightArrow, 1);
                }else {
                    setVisibility(CASELayout, GONE);
                    changeArrow(eightArrow, 0);
                }
            }
        });
    }

    public void loadFAC(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String FAC = Objects.requireNonNull(dataSnapshot.child("features and cap").getValue()).toString();
                checkSetContent(FAC, FACWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadMF(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String MF = Objects.requireNonNull(dataSnapshot.child("modifying files").getValue()).toString();
                checkSetContent(MF, MFWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadSED(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String SED = Objects.requireNonNull(dataSnapshot.child("sed").getValue()).toString();
                checkSetContent(SED, SEDWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadAWK(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String AWK = Objects.requireNonNull(dataSnapshot.child("awk command").getValue()).toString();
                checkSetContent(AWK, AWKWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadFMU(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String FMU = Objects.requireNonNull(dataSnapshot.child("file manipulation utils").getValue()).toString();
                checkSetContent(FMU, FMUWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadSM() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String SM = Objects.requireNonNull(dataSnapshot.child("string manipulation").getValue()).toString();
                checkSetContent(SM, SMWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadBE() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String BE = Objects.requireNonNull(dataSnapshot.child("boolean expressions").getValue()).toString();
                checkSetContent(BE, BEWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadCASE() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String CASE = Objects.requireNonNull(dataSnapshot.child("case").getValue()).toString();
                checkSetContent(CASE, CASEWebView);
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
            Toast.makeText(LinuxBasicShellScriptActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
        }else {
            webView.loadDataWithBaseURL(null, topic, MIME, ENCODING, null);
        }
    }
}
