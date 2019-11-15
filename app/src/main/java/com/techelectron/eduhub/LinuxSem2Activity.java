package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.techelectron.eduhub.SyllabusPagers.LinuxPager;
import com.google.android.material.tabs.TabLayout;

public class LinuxSem2Activity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    LinuxPager linuxPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_sem2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Linux");
            actionBar.setElevation(0);
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tabLayout = findViewById(R.id.tabview);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Theory"));
        tabLayout.addTab(tabLayout.newTab().setText("Practicals"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        linuxPager = new LinuxPager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(linuxPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
