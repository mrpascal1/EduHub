package com.techelectron.eduhub.CourseFragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techelectron.eduhub.PythonCourse.PythonCoursePracticalDisplayActivity;
import com.techelectron.eduhub.R;

public class PythonCoursePractical extends Fragment {

    CardView add2NosPy, factOfNosPy, hwPy, simpleInterestPy, compoundInterestPy, armstrongNoPy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_python_course_practical, container, false);

        add2NosPy = view.findViewById(R.id.add2NosPy);
        factOfNosPy = view.findViewById(R.id.factOfNosPy);
        hwPy = view.findViewById(R.id.hwPy);
        simpleInterestPy = view.findViewById(R.id.simpleInterestPy);
        compoundInterestPy = view.findViewById(R.id.compoundInterestPy);
        armstrongNoPy = view.findViewById(R.id.armstrongNoPy);

        add2NosPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent(R.string.add2NosPy);
            }
        });

        factOfNosPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent(R.string.factOfNosPy);
            }
        });

        hwPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent(R.string.hwPy);
            }
        });

        simpleInterestPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent(R.string.simpleInterestPy);
            }
        });

        compoundInterestPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent(R.string.compoundInterestPy);
            }
        });

        armstrongNoPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent(R.string.armstrongNoPy);
            }
        });

        return view;
    }

    public void setAndOpenContent(int topic){
        Intent intent = new Intent(getContext(), PythonCoursePracticalDisplayActivity.class);
        intent.putExtra("Python Practicals", topic);
        startActivity(intent);
    }
}
