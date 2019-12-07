package com.techelectron.eduhub.PythonCourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;
import com.techelectron.eduhub.R;

public class PythonCoursePracticalDisplayActivity extends AppCompatActivity implements HighlightJsView.OnThemeChangedListener {

    HighlightJsView highlightJsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course_practical_display);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Practical");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        highlightJsView = findViewById(R.id.highlight_view);

        Intent intent = getIntent();
        final int message = intent.getIntExtra("Python Practicals", 0);

        highlightJsView.setOnThemeChangedListener(this);
        //change theme and set language to auto detect
        highlightJsView.setTheme(Theme.ANDROID_STUDIO);
        highlightJsView.setHighlightLanguage(Language.PYTHON);
        highlightJsView.setShowLineNumbers(true);
        //load the source (can be loaded by String, File or URL)
        highlightJsView.setSource(getString(message));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onThemeChanged(@NonNull Theme theme) {

    }
}
