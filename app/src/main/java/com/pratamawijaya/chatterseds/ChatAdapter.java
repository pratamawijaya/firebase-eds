package com.pratamawijaya.chatterseds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pratamawijaya.chatterseds.model.Chat;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/1/15
 * Project : ChattersEDS
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

  private Context context;
  private List<Chat> listChat;

  public ChatAdapter(Context context) {
    this.context = context;
  }

  public void setListChat(List<Chat> listChat) {
    this.listChat = listChat;
  }

  @Override public ChatHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    return new ChatHolder(
        LayoutInflater.from(context).inflate(R.layout.item_chat, viewGroup, false));
  }

  @Override public void onBindViewHolder(ChatHolder holder, int position) {
    holder.username.setText(listChat.get(position).user);
    holder.message.setText(listChat.get(position).message);
  }

  @Override public int getItemCount() {
    return listChat.size();
  }

  public class ChatHolder extends RecyclerView.ViewHolder {

    TextView username;
    TextView message;

    public ChatHolder(View itemView) {
      super(itemView);

      username = (TextView) itemView.findViewById(R.id.username);
      message = (TextView) itemView.findViewById(R.id.message);
    }
  }
}
