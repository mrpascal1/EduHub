package com.techelectron.eduhub.CProgS2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techelectron.eduhub.R;

import java.util.Objects;

public class CProgS2CommonActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog progressDialog;

    DatabaseReference databaseReference;

    public static final String MIME = "text/html";
    public static final String ENCODING = "UTF-8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprog_s2_common);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("C Programming S2");

        progressDialog = new ProgressDialog(this);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra("C Programming");

        if (actionBar != null) {
            actionBar.setTitle(message);
        }
        loadCommonDB(message);
    }

    public void loadCommonDB(final String keyName){
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String key = Objects.requireNonNull(dataSnapshot.child(keyName).getValue()).toString();
                if (key.equals("")){
                    progressDialog.dismiss();
                    comingSoonToast();
                }else {
                    progressDialog.dismiss();
                    webView.loadDataWithBaseURL(null, key, MIME, ENCODING, null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void comingSoonToast(){
        Toast.makeText(this, "Coming Soon", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
