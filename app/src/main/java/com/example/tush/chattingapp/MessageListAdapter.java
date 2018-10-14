package com.example.tush.chattingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tush.chattingapp.helper.Message;

import java.util.ArrayList;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageViewHolder> {
    private Context context;
    private ArrayList<Message> mlist;
    boolean self = false;

    public MessageListAdapter(Context context, ArrayList<Message> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        switch (type) {
            case 1:
                view = layoutInflater.inflate(R.layout.list_item_message_right, viewGroup, false);
                return new MessageViewHolder(view);
            case 0:
                view = layoutInflater.inflate(R.layout.list_item_message_left, viewGroup, false);
                return new MessageViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {
        Message obj = mlist.get(i);
        messageViewHolder.sender.setText(obj.getFromName());
        messageViewHolder.msg.setText(obj.getMessage());
    }

    @Override
    public int getItemViewType(int position) {
        if (mlist.get(position).isSelf()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView sender, msg;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            sender = itemView.findViewById(R.id.lblMsgFrom);
            msg = itemView.findViewById(R.id.txtMsg);
        }
    }
}
