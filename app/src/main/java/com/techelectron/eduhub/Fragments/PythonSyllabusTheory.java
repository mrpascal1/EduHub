package com.techelectron.eduhub.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.techelectron.eduhub.AboutUsActivity;
import com.techelectron.eduhub.Adapters.TopicAdapter;
import com.techelectron.eduhub.Models.ModelTopic;
import com.techelectron.eduhub.R;
import com.techelectron.eduhub.SyllabusActivity;

import java.util.ArrayList;


public class PythonSyllabusTheory extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ModelTopic> topicList;
    TopicAdapter topicAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_syllabus_theory, container, false);

        recyclerView = view.findViewById(R.id.pythonRecyclerView);

        activateList();

        return view;
    }

    private void activateList(){

        topicList = new ArrayList<>();
        topicAdapter = new TopicAdapter(getContext(), topicList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(topicAdapter);

        topicList.add(new ModelTopic("Introduction"));
        topicList.add(new ModelTopic("Variables"));
        topicList.add(new ModelTopic("Syntax"));


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        //MenuItem item = menu.findItem(R.id.settings);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.aboutus){
            Intent intent = new Intent(getContext(), AboutUsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
