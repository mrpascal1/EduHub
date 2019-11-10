package com.techelectron.eduhub.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techelectron.eduhub.LinuxS2.LinuxBasicShellScriptActivity;
import com.techelectron.eduhub.LinuxS2.LinuxCommandLineActivity;
import com.techelectron.eduhub.LinuxS2.LinuxDocumentationActivity;
import com.techelectron.eduhub.LinuxS2.LinuxFileOperationsActivity;
import com.techelectron.eduhub.LinuxS2.LinuxGraphicalDesktopActivity;
import com.techelectron.eduhub.LinuxS2.LinuxIntro;
import com.techelectron.eduhub.LinuxS2.LinuxNetworkingActivity;
import com.techelectron.eduhub.LinuxS2.LinuxSecurityActivity;
import com.techelectron.eduhub.LinuxS2.LinuxStructureActivity;
import com.techelectron.eduhub.R;


public class LinuxSyllabusTheory extends Fragment {

    CardView chapter1, chapter2, chapter3, chapter4, chapter5, chapter6, chapter7, chapter8, chapter9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linux_syllabus_theory, container, false);

        chapter1 = view.findViewById(R.id.chapter1);
        chapter2 = view.findViewById(R.id.chapter2);
        chapter3 = view.findViewById(R.id.chapter3);
        chapter4 = view.findViewById(R.id.chapter4);
        chapter5 = view.findViewById(R.id.chapter5);
        chapter6 = view.findViewById(R.id.chapter6);
        chapter7 = view.findViewById(R.id.chapter7);
        chapter8 = view.findViewById(R.id.chapter8);
        chapter9 = view.findViewById(R.id.chapter9);

        chapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxIntro.class);
                startActivity(intent);
            }
        });

        chapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxStructureActivity.class);
                startActivity(intent);
            }
        });

        chapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxGraphicalDesktopActivity.class);
                startActivity(intent);
            }
        });

        chapter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxCommandLineActivity.class);
                startActivity(intent);
            }
        });

        chapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxDocumentationActivity.class);
                startActivity(intent);
            }
        });

        chapter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxFileOperationsActivity.class);
                startActivity(intent);
            }
        });

        chapter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxSecurityActivity.class);
                startActivity(intent);
            }
        });

        chapter8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxNetworkingActivity.class);
                startActivity(intent);
            }
        });

        chapter9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LinuxBasicShellScriptActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
