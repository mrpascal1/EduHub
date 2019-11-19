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

public class LinuxSecurityActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader;
    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow;

    CardView ULSCard, UORCard, SUDOCMDCard, BUACard, USSHCard;

    LinearLayout ULSLayout, UORLayout, SUDOCMDLayout, BUALayout, USSHLayout;

    WebView ULSWebView, UORWebView, SUDOCMDWebView, BUAWebView, USSHWebView;

    DatabaseReference databaseReference;

    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_security);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Security");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2").child("Security");

        firstHeader = findViewById(R.id.firstHeader);
        secondHeader = findViewById(R.id.secondHeader);
        thirdHeader = findViewById(R.id.thirdHeader);
        fourthHeader = findViewById(R.id.fourthHeader);
        fifthHeader = findViewById(R.id.fifthHeader);

        firstArrow = findViewById(R.id.firstArrow);
        secondArrow = findViewById(R.id.secondArrow);
        thirdArrow = findViewById(R.id.thirdArrow);
        fourthArrow = findViewById(R.id.fourthArrow);
        fifthArrow = findViewById(R.id.fifthArrow);

        ULSCard = findViewById(R.id.ULSCard);
        UORCard = findViewById(R.id.UORCard);
        SUDOCMDCard = findViewById(R.id.SUDOCMDCard);
        BUACard = findViewById(R.id.BUACard);
        USSHCard = findViewById(R.id.USSHCard);

        ULSLayout = findViewById(R.id.ULSLayout);
        UORLayout = findViewById(R.id.UORLayout);
        SUDOCMDLayout = findViewById(R.id.SUDOCMDLayout);
        BUALayout = findViewById(R.id.BUALayout);
        USSHLayout = findViewById(R.id.USSHLayout);

        ULSWebView = findViewById(R.id.ULSWebView);
        UORWebView = findViewById(R.id.UORWebView);
        SUDOCMDWebView = findViewById(R.id.SUDOCMDWebView);
        BUAWebView = findViewById(R.id.BUAWebView);
        USSHWebView = findViewById(R.id.USSHWebView);

        initWebView(ULSWebView);
        initWebView(UORWebView);
        initWebView(SUDOCMDWebView);
        initWebView(BUAWebView);
        initWebView(USSHWebView);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(ULSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadULS();
                        }
                    }).start();
                    setVisibility(ULSLayout, VISIBLE);
                    animate(ULSCard);
                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(ULSLayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(UORLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadUOR();
                        }
                    }).start();
                    setVisibility(UORLayout, VISIBLE);
                    animate(UORCard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(UORLayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(SUDOCMDLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadSUDOCMD();
                        }
                    }).start();
                    setVisibility(SUDOCMDLayout, VISIBLE);
                    animate(SUDOCMDCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(SUDOCMDLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(BUALayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadBUA();
                        }
                    }).start();
                    setVisibility(BUALayout, VISIBLE);
                    animate(BUACard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(BUALayout, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(USSHLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadUSSH();
                        }
                    }).start();
                    setVisibility(USSHLayout, VISIBLE);
                    animate(USSHCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(USSHLayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });
    }

    public void loadULS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String ULS = Objects.requireNonNull(dataSnapshot.child("understanding linux sec").getValue()).toString();
                if (ULS.equals("")){
                    Toast.makeText(LinuxSecurityActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                }else {
                    ULSWebView.loadDataWithBaseURL(null, ULS, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadUOR(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String UOR = Objects.requireNonNull(dataSnapshot.child("uses of root").getValue()).toString();
                if (UOR.equals("")){
                    Toast.makeText(LinuxSecurityActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();

                }else {
                    UORWebView.loadDataWithBaseURL(null, UOR, MIME, ENCODING, null);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadSUDOCMD(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String sudoCommand = Objects.requireNonNull(dataSnapshot.child("sudo command").getValue()).toString();
                if (sudoCommand.equals("")){
                    Toast.makeText(LinuxSecurityActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();

                }else {
                    SUDOCMDWebView.loadDataWithBaseURL(null, sudoCommand, MIME, ENCODING, null);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadBUA(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String BUA = Objects.requireNonNull(dataSnapshot.child("bypassing user auth").getValue()).toString();
                if (BUA.equals("")){
                    Toast.makeText(LinuxSecurityActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();

                }else {
                    BUAWebView.loadDataWithBaseURL(null, BUA, MIME, ENCODING, null);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadUSSH(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String USSH = Objects.requireNonNull(dataSnapshot.child("understanding ssh").getValue()).toString();
                if (USSH.equals("")){
                    Toast.makeText(LinuxSecurityActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();

                }else {
                    USSHWebView.loadDataWithBaseURL(null, USSH, MIME, ENCODING, null);

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
