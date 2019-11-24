package com.techelectron.eduhub.PythonS2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.techelectron.eduhub.R;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PythonIntroActivity extends AppCompatActivity {


    TextView theoryPythonIntro;
    DatabaseReference databaseReference;
    Typeface timesNewRoman;

    CardView justHeader, introHeader, hiddenJustHeader, hiddenIntroHeader;

    TextView intro2tv,introHeaderArrow, justHeaderArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_intro);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Python");
            //actionBar.setElevation(0);
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        justHeader = findViewById(R.id.justHeader);
        introHeader = findViewById(R.id.introHeader);
        hiddenJustHeader = findViewById(R.id.justHeaderBelow);
        hiddenIntroHeader = findViewById(R.id.introHeaderBelow);

        intro2tv = findViewById(R.id.intro2Tv);
        introHeaderArrow = findViewById(R.id.introHeaderArrow);
        justHeaderArrow = findViewById(R.id.justHeaderArrow);
        theoryPythonIntro = findViewById(R.id.theoryIntroTv);

        justHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (theoryPythonIntro.getVisibility() == View.GONE) {
                    theoryPythonIntro.setVisibility(View.VISIBLE);
                    hiddenJustHeader.setAlpha(0.0f);
                    hiddenJustHeader.animate().translationY(hiddenJustHeader.getHeight()).alpha(1.0f).setListener(null);
                    justHeaderArrow.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_up, 0);
                }else {
                    theoryPythonIntro.setVisibility(View.GONE);
                    justHeaderArrow.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
                }
            }
        });

        introHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intro2tv.getVisibility() == View.GONE) {
                    intro2tv.setVisibility(View.VISIBLE);

                    hiddenIntroHeader.setAlpha(0.0f);
                    hiddenIntroHeader.animate().translationY(hiddenIntroHeader.getHeight()).alpha(1.0f).setListener(null);

                    introHeaderArrow.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_up, 0);
                }else {
                    intro2tv.setVisibility(View.GONE);
                    introHeaderArrow.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
                }
            }
        });

        timesNewRoman = Typeface.createFromAsset(getAssets(), "times-new-roman.ttf");
        theoryPythonIntro.setTypeface(timesNewRoman);

        new Thread(new Runnable() {
            @Override
            public void run() { //TODO: Inside The thread
                loadTheory();
            }
        }).start();
    }

    public void loadTheory(){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Theory").child("Python");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String introTheory = Objects.requireNonNull(dataSnapshot.child("Introduction").getValue()).toString();

                //TODO: Unstable or Heavy code , finding an optimal solutions
                String highLightIntro = introTheory;
                Pattern pattern = Pattern.compile("Python");
                Matcher m = pattern.matcher(highLightIntro);
                SpannableString str = new SpannableString(highLightIntro);
                while (m.find()){

                    str.setSpan(new ForegroundColorSpan(Color.BLUE), m.start(), m.end(), 0);
                }
                theoryPythonIntro.setText(str);


                //theoryPythonIntro.setText(introTheory);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
