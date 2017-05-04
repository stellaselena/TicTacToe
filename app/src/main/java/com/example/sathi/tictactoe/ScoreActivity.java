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
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private static final String TAG = "ScoreActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle bundle = getIntent().getExtras();
        String x = bundle.getString("xScore");
        String o = bundle.getString("oScore");
        String[] scores = new String[]{x, o};

        List<String> scoreList = Arrays.asList(scores);


        Collections.sort(scoreList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o2) - extractInt(o1);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");

                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });


        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, scores);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

    }


}


