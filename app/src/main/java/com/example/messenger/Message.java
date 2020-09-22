package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    EditText replyEdt;
    Button sendBtn;
    TextView messageTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("message");

        replyEdt = findViewById(R.id.edtMessage);
        sendBtn = findViewById(R.id.sendBtn);
        messageTxt = findViewById(R.id.txtMessage);

        messageTxt.setText(msg);
    }

    public void sendReply(View view) {
        String reply = replyEdt.getText().toString();

        replyEdt.setText("");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("reply", reply);

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
