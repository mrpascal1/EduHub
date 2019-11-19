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

public class LinuxDocumentationActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader;
    TextView firstArrow, secondArrow, thirdArrow;

    CardView MANPAGESCard, GNUINFOCard, MOREDOCSCard;

    LinearLayout MANPAGESLayout, GNUINFOLayout, MOREDOCSLayout;

    WebView MANPAGESWebView, GNUINFOWebView, MOREDOCSWebView;

    DatabaseReference databaseReference;
    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_documentation);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Linux Documentation");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2").child("Linux Documentation");

        firstHeader = findViewById(R.id.firstHeader);
        secondHeader = findViewById(R.id.secondHeader);
        thirdHeader = findViewById(R.id.thirdHeader);

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);

        MANPAGESCard = findViewById(R.id.MANPAGESCard);
        GNUINFOCard = findViewById(R.id.GNUINFOCard);
        MOREDOCSCard = findViewById(R.id.MOREDOCSCard);

        MANPAGESLayout = findViewById(R.id.MANPAGESLayout);
        GNUINFOLayout = findViewById(R.id.GNUINFOLayout);
        MOREDOCSLayout = findViewById(R.id.MOREDOCSLayout);

        MANPAGESWebView = findViewById(R.id.MANPAGESWebView);
        GNUINFOWebView = findViewById(R.id.GNUINFOWebView);
        MOREDOCSWebView = findViewById(R.id.MOREDOCSWebView);

        initWebView(MANPAGESWebView);
        initWebView(GNUINFOWebView);
        initWebView(MOREDOCSWebView);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(MANPAGESLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadMANPAGES();
                        }
                    }).start();
                    setVisibility(MANPAGESLayout, VISIBLE);
                    animate(MANPAGESCard);
                    changeArrow(firstArrow,1);
                }else {
                    setVisibility(MANPAGESLayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(GNUINFOLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadGNUINFO();
                        }
                    }).start();
                    setVisibility(GNUINFOLayout, VISIBLE);
                    animate(GNUINFOCard);
                    changeArrow(secondArrow,1);
                }else {
                    setVisibility(GNUINFOLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(MOREDOCSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadMOREDOCS();
                        }
                    }).start();
                    setVisibility(MOREDOCSLayout, VISIBLE);
                    animate(MOREDOCSCard);
                    changeArrow(thirdArrow,1);
                }else {
                    setVisibility(MOREDOCSLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

    }

    public void loadMANPAGES(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String manPages = Objects.requireNonNull(dataSnapshot.child("man pages").getValue()).toString();
                if (manPages.equals("")) {
                    Toast.makeText(LinuxDocumentationActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    MANPAGESWebView.loadDataWithBaseURL(null, manPages, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadGNUINFO(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String gnuInfo = Objects.requireNonNull(dataSnapshot.child("gnu info").getValue()).toString();
                if (gnuInfo.equals("")) {
                    Toast.makeText(LinuxDocumentationActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    GNUINFOWebView.loadDataWithBaseURL(null, gnuInfo, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadMOREDOCS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String moreDocs = Objects.requireNonNull(dataSnapshot.child("more documentation").getValue()).toString();
                if (moreDocs.equals("")) {
                    Toast.makeText(LinuxDocumentationActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    MOREDOCSWebView.loadDataWithBaseURL(null, moreDocs, MIME, ENCODING, null);
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
