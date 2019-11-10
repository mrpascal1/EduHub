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

public class LinuxFileOperationsActivity extends AppCompatActivity {

    CardView firstHeader, secondHeader, thirdHeader, fourthHeader, fifthHeader;
    TextView firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow;

    CardView FSARCHCard, FTYPECard, FATTRCard, BACKUPCard, CMPRSCard;

    LinearLayout FSARCHLayout, FTYPELayout, FATTRLayout, BACKUPLayout, CMPRSLayout;

    WebView FSARCHWebView, FTYPEWebView, FATTRWebView, BACKUPWebView, CMPRSWebView;

    DatabaseReference databaseReference;

    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    public static final int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_file_operations);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Linux");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("LinuxS2").child("File Operations");

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

        FSARCHCard = findViewById(R.id.FSARCHCard);
        FTYPECard = findViewById(R.id.FTYPECard);
        FATTRCard = findViewById(R.id.FATTRCard);
        BACKUPCard = findViewById(R.id.BACKUPCard);
        CMPRSCard = findViewById(R.id.CMPRSCard);

        FSARCHLayout = findViewById(R.id.FSARCHLayout);
        FTYPELayout = findViewById(R.id.FTYPELayout);
        FATTRLayout = findViewById(R.id.FATTRLayout);
        BACKUPLayout = findViewById(R.id.BACKUPLayout);
        CMPRSLayout = findViewById(R.id.CMPRSLayout);

        FSARCHWebView = findViewById(R.id.FSARCHWebView);
        FTYPEWebView = findViewById(R.id.FTYPEWebView);
        FATTRWebView = findViewById(R.id.FATTRWebView);
        BACKUPWebView = findViewById(R.id.BACKUPWebView);
        CMPRSWebView = findViewById(R.id.CMPRSWebView);

        initWebView(FSARCHWebView);
        initWebView(FTYPEWebView);
        initWebView(FATTRWebView);
        initWebView(BACKUPWebView);
        initWebView(CMPRSWebView);

        firstHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(FSARCHLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadFSARCH();
                        }
                    }).start();
                    setVisibility(FSARCHLayout, VISIBLE);
                    animate(FSARCHCard);
                    changeArrow(firstArrow, 1);
                }else {
                    setVisibility(FSARCHLayout, GONE);
                    changeArrow(firstArrow, 0);
                }
            }
        });

        secondHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(FTYPELayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadFTYPE();
                        }
                    }).start();
                    setVisibility(FTYPELayout, VISIBLE);
                    animate(FTYPECard);
                    changeArrow(secondArrow, 1);
                }else {
                    setVisibility(FTYPELayout, GONE);
                    changeArrow(secondArrow, 0);
                }
            }
        });

        thirdHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(FATTRLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadFATTR();
                        }
                    }).start();
                    setVisibility(FATTRLayout, VISIBLE);
                    animate(FATTRCard);
                    changeArrow(thirdArrow, 1);
                }else {
                    setVisibility(FATTRLayout, GONE);
                    changeArrow(thirdArrow, 0);
                }
            }
        });

        fourthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(BACKUPLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadBACKUP();
                        }
                    }).start();
                    setVisibility(BACKUPLayout, VISIBLE);
                    animate(BACKUPCard);
                    changeArrow(fourthArrow, 1);
                }else {
                    setVisibility(BACKUPLayout, GONE);
                    changeArrow(fourthArrow, 0);
                }
            }
        });

        fifthHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVisibility(CMPRSLayout)){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadCMPRS();
                        }
                    }).start();
                    setVisibility(CMPRSLayout, VISIBLE);
                    animate(CMPRSCard);
                    changeArrow(fifthArrow, 1);
                }else {
                    setVisibility(CMPRSLayout, GONE);
                    changeArrow(fifthArrow, 0);
                }
            }
        });
    }

    public void loadFSARCH(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String FSARCH = Objects.requireNonNull(dataSnapshot.child("filesystem arch").getValue()).toString();
                if (FSARCH.equals("")){
                    Toast.makeText(LinuxFileOperationsActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    FSARCHWebView.loadDataWithBaseURL(null, FSARCH, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadFTYPE(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String FTYPE = Objects.requireNonNull(dataSnapshot.child("file types").getValue()).toString();
                if (FTYPE.equals("")){
                    Toast.makeText(LinuxFileOperationsActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    FTYPEWebView.loadDataWithBaseURL(null, FTYPE, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadFATTR(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String FATTR = Objects.requireNonNull(dataSnapshot.child("file attributes").getValue()).toString();
                if (FATTR.equals("")){
                    Toast.makeText(LinuxFileOperationsActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    FATTRWebView.loadDataWithBaseURL(null, FATTR, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadBACKUP(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String BACKUP = Objects.requireNonNull(dataSnapshot.child("backup").getValue()).toString();
                if (BACKUP.equals("")){
                    Toast.makeText(LinuxFileOperationsActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    BACKUPWebView.loadDataWithBaseURL(null, BACKUP, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadCMPRS(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String CMPRS = Objects.requireNonNull(dataSnapshot.child("compression").getValue()).toString();
                if (CMPRS.equals("")){
                    Toast.makeText(LinuxFileOperationsActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }else {
                    CMPRSWebView.loadDataWithBaseURL(null, CMPRS, MIME, ENCODING, null);
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
}
