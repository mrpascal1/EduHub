package com.techelectron.eduhub.SyllabusPagers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.techelectron.eduhub.Fragments.PythonSyllabusPractical;
import com.techelectron.eduhub.Fragments.PythonSyllabusTheory;

public class Python2Pager extends FragmentStatePagerAdapter {

    int tabs;
    public Python2Pager(@NonNull FragmentManager fm, int Tabs) {
        super(fm);
        this.tabs = Tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PythonSyllabusTheory theoryFragment = new PythonSyllabusTheory();
                return theoryFragment;
            case 1:
                PythonSyllabusPractical practicalsFragment = new PythonSyllabusPractical();
                return practicalsFragment;
            default:
                return null;
        }
        //return null;
    }

    @Override
    public int getCount() {
        return tabs;
    }
}