package com.techelectron.eduhub.SyllabusPagers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.techelectron.eduhub.Fragments.CProgS2Practical;
import com.techelectron.eduhub.Fragments.CProgS2Theory;

public class CProgS2Pager extends FragmentStatePagerAdapter {

    int tabs;
    public CProgS2Pager(@NonNull FragmentManager fm, int Tabs) {
        super(fm);
        this.tabs = Tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CProgS2Theory theoryFragment = new CProgS2Theory();
                return theoryFragment;
            case 1:
                CProgS2Practical practicalsFragment = new CProgS2Practical();
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
