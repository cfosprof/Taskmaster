package com.foster917.taskmaster;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    public TextView title;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.task_title);
    }

}