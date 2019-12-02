package com.example.yabeeprototypes;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder>
{
    private List<Notification> listData;
    private int layout;
    private int containerId;

    public NotificationsAdapter(List<Notification> listData, int containerId)
    {
        this.listData = listData;
        this.containerId = containerId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.notification_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Notification myListData = listData.get(position);
        if (listData.get(position) != null)
        {
            String message = listData.get(position).getNotificationMessage();
            System.out.println(message);
            holder.textView.setText(message);
        }
        else
        {
            String invalid = "null";
            holder.textView.setText(invalid);
        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("POST ID", myListData.getPostID());
                Toast.makeText(v.getContext(), "my name is jon ramos", Toast.LENGTH_SHORT).show();

                FragmentActivity activity = (FragmentActivity) v.getContext();

                ViewPost viewPost = new ViewPost();
                viewPost.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(containerId, viewPost).commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.notification_message);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }



}
