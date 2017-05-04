package com.example.sathi.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartScreenActivity extends AppCompatActivity {
    public EditText p1, p2;
    private String player1 = "";
    private String player2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        p1 = (EditText) findViewById(R.id.player1);
        p2 = (EditText) findViewById(R.id.player2);
        Button buttonStart = (Button) findViewById(R.id.startButton);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1 = p1.getText().toString();
                player2 = p2.getText().toString();
                Intent intent = new Intent(StartScreenActivity.this, BoardActivity.class);
                intent.putExtra("player1", player1);
                intent.putExtra("player2", player2);
                startActivity(intent);
            }
        });
    }
}
