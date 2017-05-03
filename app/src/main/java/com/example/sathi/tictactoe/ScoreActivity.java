package com.example.sathi.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ScoreActivity extends AppCompatActivity {
    private static final String TAG = "ScoreActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle bundle = getIntent().getExtras();
        String x = bundle.getString("xScore");
        String o = bundle.getString("oScore");
        String [] scores = new String[]{x,o };





        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, scores);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

    }


}


