package com.techelectron.eduhub.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techelectron.eduhub.Models.ModelTopic;
import com.techelectron.eduhub.PythonIntroActivity;
import com.techelectron.eduhub.R;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.MyHolder> {

    Context context;
    List<ModelTopic> topicList;
    public TopicAdapter(Context context, List<ModelTopic> topicList){
        this.context = context;
        this.topicList = topicList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.programming_list, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final String topic = topicList.get(position).getTopics();
        holder.topicList.setText(topic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (topic.equals("Introduction")){
                    Intent intent = new Intent(context, PythonIntroActivity.class);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        TextView topicList;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            topicList = itemView.findViewById(R.id.topicList);
        }

    }
}
