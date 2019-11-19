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

public class LinuxGraphicalDesktopActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader;
    TextView firstArrow, secondArrow, thirdArrow;

    CardView NETMGCard, TXTEDITCard, MMAPPSCard;

    LinearLayout NETMGLayout, TXTEDITLayout, MMAPPSLayout;

    WebView NETMGWebView, TXTEDITWebView, MMAPPSWebView;

    DatabaseReference databaseReference;
    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_graphical_desktop);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Graphical Desktop");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2");

        firstHeader = findViewById(R.id.firstHeader);
        secondHeader = findViewById(R.id.secondHeader);
        thirdHeader = findViewById(R.id.thirdHeader);

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);

        NETMGCard = findViewById(R.id.NETMGCard);
        TXTEDITCard = findViewById(R.id.TXTEDITCard);
        MMAPPSCard = findViewById(R.id.MMAPPSCard);

        NETMGLayout = findViewById(R.id.NETMGLayout);
        TXTEDITLayout = findViewById(R.id.TXTEDITLayout);
        MMAPPSLayout = findViewById(R.id.MMAPPSLayout);

        NETMGWebView = findViewById(R.id.NETMGWebView);
        TXTEDITWebView = findViewById(R.id.TXTEDITWebView);
        MMAPPSWebView = findViewById(R.id.MMAPPSWebView);

        initWebView(NETMGWebView);
        initWebView(TXTEDITWebView);
        initWebView(MMAPPSWebView);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(NETMGLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadNETMG();
                        }
                    }).start();
                    setVisibility(NETMGLayout, VISIBLE);
                    animate(NETMGCard);
                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(NETMGLayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(TXTEDITLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadTXTEDIT();
                        }
                    }).start();
                    setVisibility(TXTEDITLayout, VISIBLE);
                    animate(TXTEDITCard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(TXTEDITLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(MMAPPSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadMMAPPS();
                        }
                    }).start();
                    setVisibility(MMAPPSLayout, VISIBLE);
                    animate(MMAPPSCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(MMAPPSLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

    }

    public void loadNETMG(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String NETMG = Objects.requireNonNull(dataSnapshot.child("network management").getValue()).toString();
                if (NETMG.equals("")) {
                    Toast.makeText(LinuxGraphicalDesktopActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    NETMGWebView.loadDataWithBaseURL(null, NETMG, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadTXTEDIT(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String TXTEDIT = Objects.requireNonNull(dataSnapshot.child("text editors").getValue()).toString();
                if (TXTEDIT.equals("")) {
                    Toast.makeText(LinuxGraphicalDesktopActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    TXTEDITWebView.loadDataWithBaseURL(null, TXTEDIT, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadMMAPPS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String MMAPPS = Objects.requireNonNull(dataSnapshot.child("multimedia applications").getValue()).toString();
                if (MMAPPS.equals("")) {
                    Toast.makeText(LinuxGraphicalDesktopActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else {
                    MMAPPSWebView.loadDataWithBaseURL(null, MMAPPS, MIME, ENCODING, null);
                }
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
