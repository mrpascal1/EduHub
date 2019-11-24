package com.techelectron.eduhub.CourseFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.techelectron.eduhub.CommonWebActivity;
import com.techelectron.eduhub.PythonCourse.PythonCourseActivity;
import com.techelectron.eduhub.PythonCourse.PythonCourseIntro;
import com.techelectron.eduhub.QuestionPapers.CsYear3Activity;
import com.techelectron.eduhub.R;


public class PythonCourseTheory extends Fragment {

    CardView introduction, overview, envSetup, basicSyntax, varTypes, basicOperators,
            decisionMaking, loops, numbers, strings, lists, tuples, dictionary, dateAndTime, functions, modules, files, exceptions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_python_course_theory, container, false);

        introduction = view.findViewById(R.id.introPythonC);
        overview = view.findViewById(R.id.overviewPythonC);
        envSetup = view.findViewById(R.id.envSetupPythonC);
        basicSyntax = view.findViewById(R.id.basicStxPythonC);
        varTypes = view.findViewById(R.id.varTypesPythonC);
        basicOperators = view.findViewById(R.id.basicOpsPythonC);
        decisionMaking = view.findViewById(R.id.dcnMakingPythonC);
        loops = view.findViewById(R.id.loopsPythonC);
        numbers = view.findViewById(R.id.numbersPythonC);
        strings = view.findViewById(R.id.stringsPythonC);
        lists = view.findViewById(R.id.listsPythonC);
        tuples = view.findViewById(R.id.tuplesPythonC);
        dictionary = view.findViewById(R.id.dictPythonC);
        dateAndTime = view.findViewById(R.id.dateTimePythonC);
        functions = view.findViewById(R.id.funcPythonC);
        modules = view.findViewById(R.id.modsPythonC);
        files = view.findViewById(R.id.filesPythonC);
        exceptions = view.findViewById(R.id.exceptionsPythonC);

        introduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Introduction");
            }
        });

        overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Overview");
            }
        });

        envSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Environment Setup");
            }
        });

        basicSyntax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Basic Syntax");
            }
        });

        varTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Variable Types");
            }
        });

        basicOperators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Basic Operators");
            }
        });

        decisionMaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Decision Making");
            }
        });

        loops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Loops");
            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Numbers");
            }
        });

        strings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Strings");
            }
        });

        lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Lists");
            }
        });

        tuples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Tuples");
            }
        });

        dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Dictionary");
            }
        });

        dateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Date and Time");
            }
        });

        functions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Functions");
            }
        });

        modules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Modules");
            }
        });

        files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Files");
            }
        });

        exceptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenCourse("Exceptions");
            }
        });

        return view;
    }

    private void setAndOpenCourse(String topic){
        Intent intent = new Intent(getContext(), PythonCourseIntro.class);
        intent.putExtra("Python Course", topic);
        startActivity(intent);
    }
}
