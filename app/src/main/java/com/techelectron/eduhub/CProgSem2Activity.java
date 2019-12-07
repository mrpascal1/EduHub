package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.techelectron.eduhub.SyllabusPagers.CProgS2Pager;

public class CProgSem2Activity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    CProgS2Pager cProgS2Pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprog_sem2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("C Programming");
            actionBar.setElevation(0);
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tabLayout = findViewById(R.id.tabview);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Theory"));
        tabLayout.addTab(tabLayout.newTab().setText("Practicals"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        cProgS2Pager = new CProgS2Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(cProgS2Pager);

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
