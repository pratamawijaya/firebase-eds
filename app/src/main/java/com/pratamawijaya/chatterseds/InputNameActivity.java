package com.pratamawijaya.chatterseds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputNameActivity extends AppCompatActivity {

  Button btnLogin;
  EditText inputUsername;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_iput_name);

    // inisiasi view
    btnLogin = (Button) findViewById(R.id.btn_login);
    inputUsername = (EditText) findViewById(R.id.input_username);


    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        //
        String username = inputUsername.getText().toString();

        startActivity(
            new Intent(
                InputNameActivity.this, MainActivity.class)
                .putExtra("username", username)
        );
      }
    });
  }
}
