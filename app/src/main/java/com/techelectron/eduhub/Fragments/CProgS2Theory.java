package com.techelectron.eduhub.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techelectron.eduhub.CProgS2.CProgS2CommonActivity;
import com.techelectron.eduhub.GreenTech.GreenTechCommonActivity;
import com.techelectron.eduhub.GreenTech.GreenTechTheoryActivity;
import com.techelectron.eduhub.R;

public class CProgS2Theory extends Fragment {

    CardView chapter1, chapter2, chapter3, chapter4, chapter5, chapter6, chapter7, chapter8, chapter9, chapter10
            ,chapter11, chapter12, chapter13, chapter14, chapter15;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cprog_s2_theory, container, false);

        chapter1 = view.findViewById(R.id.cChapter1);
        chapter2 = view.findViewById(R.id.cChapter2);
        chapter3 = view.findViewById(R.id.cChapter3);
        chapter4 = view.findViewById(R.id.cChapter4);
        chapter5 = view.findViewById(R.id.cChapter5);
        chapter6 = view.findViewById(R.id.cChapter6);
        chapter7 = view.findViewById(R.id.cChapter7);
        chapter8 = view.findViewById(R.id.cChapter8);
        chapter9 = view.findViewById(R.id.cChapter9);
        chapter10 = view.findViewById(R.id.cChapter10);
        chapter11 = view.findViewById(R.id.cChapter11);
        chapter12 = view.findViewById(R.id.cChapter12);
        chapter13 = view.findViewById(R.id.cChapter13);
        chapter14 = view.findViewById(R.id.cChapter14);
        chapter15 = view.findViewById(R.id.cChapter15);

        chapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Structure of C program");
            }
        });

        chapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Data");
            }
        });

        chapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Variables");
            }
        });

        chapter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Types of operators");
            }
        });

        chapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Iterations");
            }
        });

        chapter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Arrays");
            }
        });

        chapter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Data IO functions");
            }
        });

        chapter8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Manipulating strings");
            }
        });

        chapter9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Functions");
            }
        });

        chapter10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Recursion");
            }
        });

        chapter11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Pointer");
            }
        });

        chapter12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Dynamic memory allocation");
            }
        });

        chapter13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Structure");
            }
        });

        chapter14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndOpenContent("Unions");
            }
        });

        chapter15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    setAndOpenContent("File handling");
            }
        });

        return view;
    }

    public void setAndOpenContent(String topic){
        Intent intent = new Intent(getContext(), CProgS2CommonActivity.class);
        intent.putExtra("C Programming", topic);
        startActivity(intent);
    }
}
