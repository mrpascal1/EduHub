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

public class LinuxNetworkingActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader, sixthHeader, seventhHeader;
    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow, seventhArrow;

    CardView INTROCard, NPROTOCOLCard, IPADDRCard, DNSCard, BROWSERSCard, TFILESCard, NCOMMANDSCard;

    LinearLayout INTROLayout, NPROTOCOLLayout, IPADDRLayout, DNSLayout, BROWSERSLayout, TFILESLayout, NCOMMANDSLayout;

    WebView INTROWebView, NPROTOCOLWebView, IPADDRWebView, DNSWebView, BROWSERSWebView, TFILESWebView, NCOMMANDSWebView;

    DatabaseReference databaseReference;

    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_networking);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Linux");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2").child("Networking");


        firstHeader = findViewById(R.id.firstHeader);
        secondHeader = findViewById(R.id.secondHeader);
        thirdHeader = findViewById(R.id.thirdHeader);
        fourthHeader = findViewById(R.id.fourthHeader);
        fifthHeader = findViewById(R.id.fifthHeader);
        sixthHeader = findViewById(R.id.sixthHeader);
        seventhHeader = findViewById(R.id.seventhHeader);

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);
        fourthArrow = findViewById(R.id.fourthArrow);
        fifthArrow = findViewById(R.id.fifthArrow);
        sixthArrow = findViewById(R.id.sixthArrow);
        seventhArrow = findViewById(R.id.seventhArrow);

        INTROCard = findViewById(R.id.INTROCard);
        NPROTOCOLCard = findViewById(R.id.NPROTOCOLCard);
        IPADDRCard = findViewById(R.id.IPADDRCard);
        DNSCard = findViewById(R.id.DNSCard);
        BROWSERSCard = findViewById(R.id.BROWSERSCard);
        TFILESCard = findViewById(R.id.TFILESCard);
        NCOMMANDSCard = findViewById(R.id.NCOMMANDSCard);

        INTROLayout = findViewById(R.id.INTROLayout);
        NPROTOCOLLayout = findViewById(R.id.NPROTOCOLLayout);
        IPADDRLayout = findViewById(R.id.IPADDRLayout);
        DNSLayout = findViewById(R.id.DNSLayout);
        BROWSERSLayout = findViewById(R.id.BROWSERSLayout);
        TFILESLayout = findViewById(R.id.TFILESLayout);
        NCOMMANDSLayout = findViewById(R.id.NCOMMANDSLayout);

        INTROWebView = findViewById(R.id.INTROWebView);
        NPROTOCOLWebView = findViewById(R.id.NPROTOCOLWebView);
        IPADDRWebView = findViewById(R.id.IPADDRWebView);
        DNSWebView = findViewById(R.id.DNSWebView);
        BROWSERSWebView = findViewById(R.id.BROWSERSWebView);
        TFILESWebView = findViewById(R.id.TFILESWebView);
        NCOMMANDSWebView = findViewById(R.id.NCOMMANDSWebView);

        initWebView(INTROWebView);
        initWebView(NPROTOCOLWebView);
        initWebView(IPADDRWebView);
        initWebView(DNSWebView);
        initWebView(BROWSERSWebView);
        initWebView(TFILESWebView);
        initWebView(NCOMMANDSWebView);

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
                if (checkVisibility(NPROTOCOLLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadNPROTOCOL();
                        }
                    }).start();
                    setVisibility(NPROTOCOLLayout, VISIBLE);
                    animate(NPROTOCOLCard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(NPROTOCOLLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(IPADDRLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadIPADDR();
                        }
                    }).start();
                    setVisibility(IPADDRLayout, VISIBLE);
                    animate(IPADDRCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(IPADDRLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(DNSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadDNS();
                        }
                    }).start();
                    setVisibility(DNSLayout, VISIBLE);
                    animate(DNSCard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(DNSLayout, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(BROWSERSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadBROWSERS();
                        }
                    }).start();
                    setVisibility(BROWSERSLayout, VISIBLE);
                    animate(BROWSERSCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(BROWSERSLayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });

        sixthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(TFILESLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadTFILES();
                        }
                    }).start();
                    setVisibility(TFILESLayout, VISIBLE);
                    animate(TFILESCard);
                    changeArrow(sixthArrow, 1);
                }else {
                    setVisibility(TFILESLayout, GONE);
                    changeArrow(sixthArrow, 0);
                }
            }
        });

        seventhHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(NCOMMANDSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadNCOMMANDS();
                        }
                    }).start();
                    setVisibility(NCOMMANDSLayout, VISIBLE);
                    animate(NCOMMANDSCard);
                    changeArrow(seventhArrow, 1);
                }else {
                    setVisibility(NCOMMANDSLayout, GONE);
                    changeArrow(seventhArrow, 0);
                }
            }
        });
    }

    public void loadINTRO(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String INTRO = Objects.requireNonNull(dataSnapshot.child("intro to networking").getValue()).toString();
                checkSetContent(INTRO, INTROWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadNPROTOCOL(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String NPROTOCOL = Objects.requireNonNull(dataSnapshot.child("network protocol").getValue()).toString();
                checkSetContent(NPROTOCOL, NPROTOCOLWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadIPADDR(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String IPADDR = Objects.requireNonNull(dataSnapshot.child("ip address").getValue()).toString();
                checkSetContent(IPADDR, IPADDRWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadDNS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String DNS = Objects.requireNonNull(dataSnapshot.child("dns").getValue()).toString();
                checkSetContent(DNS, DNSWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadBROWSERS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String BROWSERS = Objects.requireNonNull(dataSnapshot.child("browsers").getValue()).toString();
                checkSetContent(BROWSERS, BROWSERSWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadTFILES(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String TFILES = Objects.requireNonNull(dataSnapshot.child("transferring files").getValue()).toString();
                checkSetContent(TFILES, TFILESWebView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadNCOMMANDS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String NCOMMANDS = Objects.requireNonNull(dataSnapshot.child("networking commands").getValue()).toString();
                checkSetContent(NCOMMANDS, NCOMMANDSWebView);
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
            Toast.makeText(LinuxNetworkingActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
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
