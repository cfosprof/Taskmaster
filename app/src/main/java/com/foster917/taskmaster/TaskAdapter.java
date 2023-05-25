package com.foster917.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private List<Task> tasks;
    private Context context;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item, parent, false);
        return new TaskViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.title.setText(task.getTitle());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TaskDetailActivity.class);
            intent.putExtra(context.getString(R.string.tasktitle), task.getTitle());
            intent.putExtra(context.getString(R.string.taskbody), task.getBody());
            intent.putExtra(context.getString(R.string.taskstate), task.getState());
            context.startActivity(intent);
        });
    }



    @Override
    public int getItemCount() {
        return tasks.size();
    }
}