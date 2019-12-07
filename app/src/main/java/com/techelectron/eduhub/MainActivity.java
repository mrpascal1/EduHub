package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.techelectron.eduhub.Adapters.ExpandListAdapter;
import com.google.android.material.navigation.NavigationView;
import com.techelectron.eduhub.PythonCourse.PythonCourseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import de.cketti.library.changelog.ChangeLog;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    ExpandableListView expListView;
    ExpandListAdapter listAdapter;

    CardView syllabusCard, pythonCard, javaCard, cprogCard, cppCard, kotlinCard, rustCard, questionPaperCard;

    ImageButton menuBtn, navBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ChangeLog cl = new ChangeLog(this);
        if (cl.isFirstRun()) {
            cl.getLogDialog().show();
        }
        /*Objects.requireNonNull(actionBar).setTitle("Course");
        getSupportActionBar().setElevation(0);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));*/

        drawerLayout = findViewById(R.id.drawer);

        /*navigationView = findViewById(R.id.nav_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);*/


        syllabusCard = findViewById(R.id.syllabusCard);
        pythonCard = findViewById(R.id.pythonCard);
        javaCard = findViewById(R.id.javaCard);
        cprogCard = findViewById(R.id.cprogCard);
        cppCard = findViewById(R.id.cppCard);
        kotlinCard = findViewById(R.id.kotlinCard);
        rustCard = findViewById(R.id.rustCard);
        questionPaperCard = findViewById(R.id.questionPaperCard);

        menuBtn = findViewById(R.id.menuBtn);
        navBtn = findViewById(R.id.navBtn);
        enableExpandableList();

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });

        navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.openDrawer(GravityCompat.START);
                } else {
                    drawerLayout.closeDrawer(GravityCompat.END);
                }

            }
        });

        syllabusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SyllabusActivity.class);
                startActivity(intent);
            }
        });

        pythonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PythonCourseActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        javaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        cprogCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        cppCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        kotlinCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        rustCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        questionPaperCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionPaperActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }

    public void showPopup() {
        PopupMenu popup = new PopupMenu(this, menuBtn);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.aboutus){
                    Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
        popup.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private void enableExpandableList() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        expListView = findViewById(R.id.left_drawer);

        prepareListData(listDataHeader, listDataChild);
        listAdapter = new ExpandListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();*/
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();*/

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                // Temporary code:

                // till here
                /*Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + Objects.requireNonNull(listDataChild.get(
                                listDataHeader.get(groupPosition))).get(childPosition), Toast.LENGTH_SHORT)
                        .show();*/
                Intent intent;
                String listHeader = listDataHeader.get(groupPosition);
                String listOption = Objects.requireNonNull(listDataChild.get(listDataHeader.get(groupPosition))).get(childPosition);
                if (listHeader.equals("Bsc CS")) {
                    switch (listOption) {
                        case "Sem 1":
                        case "Sem 3":
                        case "Sem 5":
                            Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                            break;
                        case "Sem 2":
                            intent = new Intent(MainActivity.this, CsSemTwo.class);
                            startActivity(intent);
                            break;
                        case "Sem 4":
                            intent = new Intent(MainActivity.this, CsSemFour.class);
                            startActivity(intent);
                            break;
                        case "Sem 6":
                            intent = new Intent(MainActivity.this, CsSemSix.class);
                            startActivity(intent);
                            break;
                    }
                }else if (listHeader.equals("Bsc IT")){
                    switch (listOption) {
                        case "Sem 1":
                        case "Sem 6":
                        case "Sem 5":
                        case "Sem 4":
                        case "Sem 3":
                        case "Sem 2":
                            Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }else if (listHeader.equals("Programming Languages")){
                    switch (listOption){
                        case "Python":
                            Intent pythonCourse = new Intent(MainActivity.this, PythonCourseActivity.class);
                            startActivity(pythonCourse);
                            break;
                        case "Java":
                        case "C":
                        case "C++":
                        case "Kotlin":
                        case "Rust":
                            Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }else if (listHeader.equals("Others")){
                    switch (listOption){
                        case "Help Us":
                            break;
                        case "About":
                            Intent aboutIntent = new Intent(MainActivity.this, AboutUsActivity.class);
                            startActivity(aboutIntent);
                            break;
                    }
                }
                return false;
            }
        });
    }

    private void prepareListData(List<String> listDataHeader, Map<String, List<String>> listDataChild) {


        // Adding child data
        listDataHeader.add("Bsc CS");
        listDataHeader.add("Bsc IT");
        listDataHeader.add("Programming Languages");
        listDataHeader.add("Others");

        // Adding child data
        List<String> itcs = new ArrayList<String>();
        itcs.add("Sem 1");
        itcs.add("Sem 2");
        itcs.add("Sem 3");
        itcs.add("Sem 4");
        itcs.add("Sem 5");
        itcs.add("Sem 6");


        List<String> pLang = new ArrayList<String>();
        pLang.add("Python");
        pLang.add("Java");
        pLang.add("C");
        pLang.add("C++");
        pLang.add("Kotlin");
        pLang.add("Rust");

        List<String> other = new ArrayList<String>();
        other.add("Help Us");
        other.add("About");

        listDataChild.put(listDataHeader.get(0), itcs); // Header, Child data
        listDataChild.put(listDataHeader.get(1), itcs);
        listDataChild.put(listDataHeader.get(2), pLang);
        listDataChild.put(listDataHeader.get(3), other);

    }

    /*public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
            // Place your dialog code here to display the dialog

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }*/

}
