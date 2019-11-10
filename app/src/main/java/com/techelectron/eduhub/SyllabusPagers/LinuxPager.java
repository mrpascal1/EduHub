package com.techelectron.eduhub.SyllabusPagers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.techelectron.eduhub.Fragments.LinuxSyllabusPractical;
import com.techelectron.eduhub.Fragments.LinuxSyllabusTheory;

public class LinuxPager extends FragmentStatePagerAdapter {

    int tabs;
    public LinuxPager(@NonNull FragmentManager fm, int Tabs) {
        super(fm);
        this.tabs = Tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LinuxSyllabusTheory theoryFragment = new LinuxSyllabusTheory();
                return theoryFragment;
            case 1:
                LinuxSyllabusPractical practicalsFragment = new LinuxSyllabusPractical();
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
