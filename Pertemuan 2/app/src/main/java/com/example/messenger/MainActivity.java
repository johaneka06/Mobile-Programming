package com.example.messenger;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    EditText txtMessage;
    Button btnSend;

    public final int REQUEST_CODE_REPLY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtMessage);
        txtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.sendBtn);
    }

    public void sendMsg(View view) {
        String message = txtMessage.getText().toString();
//        Toast.makeText(getBaseContext(), "Sending " + message, Toast.LENGTH_SHORT).show();

        txtMessage.setText("");

        Intent intent = new Intent(this, Message.class);
        intent.putExtra("message", message);

        //startActivity(intent); //Untuk tidak menerima reply
        startActivityForResult(intent, REQUEST_CODE_REPLY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_REPLY && resultCode == Activity.RESULT_OK) {
            String reply = data.getStringExtra("reply");
            txtView.setText(reply);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
