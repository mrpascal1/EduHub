package com.techelectron.eduhub.CoursePagers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.techelectron.eduhub.CourseFragments.PythonCoursePractical;
import com.techelectron.eduhub.CourseFragments.PythonCourseTheory;

public class PythonCoursePager extends FragmentStatePagerAdapter {

    int tabs;
    public PythonCoursePager(FragmentManager fm, int Tabs){
        super(fm);
        this.tabs = Tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PythonCourseTheory theoryFragment = new PythonCourseTheory();
                return theoryFragment;
            case 1:
                PythonCoursePractical practicalsFragment = new PythonCoursePractical();
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
