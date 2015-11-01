package com.pratamawijaya.chatterseds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.pratamawijaya.chatterseds.model.Chat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  EditText inputMessage;
  Button btnSend;
  // recyclerview
  RecyclerView recyclerView;

  // variable untuk save username
  String username;

  // variable untuk list chat
  private List<Chat> dataChat;
  private ChatAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // initialize data chat
    dataChat = new ArrayList<>();

    // ambil data dari activity sebelumnya
    username = getIntent().getStringExtra("username");

    inputMessage = (EditText) findViewById(R.id.input_message);
    btnSend = (Button) findViewById(R.id.btn_send);
    // initialize recyclerview
    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    final Firebase firebase = new Firebase("https://pratamalabs.firebaseio.com/eds");

    btnSend.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        firebase.push().setValue(new Chat(username, inputMessage.getText().toString()));
      }
    });

    adapter = new ChatAdapter(this);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
    adapter.setListChat(dataChat);

    firebase.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        dataChat.clear();

        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
          Chat chat = postSnapshot.getValue(Chat.class);
          dataChat.add(chat);
          Log.d("data", "chat - > " + chat.message + " user -> " + chat.user);
        }
        adapter.notifyDataSetChanged();

        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
      }

      @Override public void onCancelled(FirebaseError firebaseError) {

      }
    });
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
