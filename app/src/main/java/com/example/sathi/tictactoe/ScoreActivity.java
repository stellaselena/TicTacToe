package com.example.sathi.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle bundle = getIntent().getExtras();
        String score = bundle.getString("score");

        TextView scores = (TextView)findViewById(R.id.scores);
        scores.setText(score);

    }
}
