package com.example.sathi.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "BoardActivity";
    public TextView p1;
    public TextView p2;
    private Button[][] buttons;
    private TextView feedback;
    private TicTacToe game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_activity);
        p1 = (TextView) findViewById(R.id.player1);
        p2 = (TextView) findViewById(R.id.player2);
        Intent intent = getIntent();
        String player1 = intent.getExtras().getString("player1");
        String player2 = intent.getExtras().getString("player2");
        p1.setText(player1);
        p2.setText(player2);

        buttons = new Button[TicTacToe.NUM_ROWS][TicTacToe.NUM_COLUMNS];
        buttons[0][0] = (Button) findViewById(R.id.button00);
        buttons[0][1] = (Button) findViewById(R.id.button01);
        buttons[0][2] = (Button) findViewById(R.id.button02);
        buttons[1][0] = (Button) findViewById(R.id.button10);
        buttons[1][1] = (Button) findViewById(R.id.button11);
        buttons[1][2] = (Button) findViewById(R.id.button12);
        buttons[2][0] = (Button) findViewById(R.id.button20);
        buttons[2][1] = (Button) findViewById(R.id.button21);
        buttons[2][2] = (Button) findViewById(R.id.button22);

        feedback = (TextView) findViewById(R.id.feedback);

        for (int row = 0; row < TicTacToe.NUM_ROWS; row++) {
            for (int col = 0; col < TicTacToe.NUM_COLUMNS; col++) {
                buttons[row][col].setOnClickListener(this);
            }
        }
        Button restart = (Button) findViewById(R.id.restart);
        Button score = (Button) findViewById(R.id.score);

        restart.setOnClickListener(this);
        score.setOnClickListener(this);
        this.game = new TicTacToe(this);

    }

    public void onClick(View view) {
        if (view.getId() == R.id.restart) {
            game.resetGame();
        }
        if (view.getId() == R.id.score) {
            Intent intent = new Intent(BoardActivity.this, ScoreActivity.class);
            intent.putExtra("xScore", xScore());
            intent.putExtra("oScore", oScore());
            startActivity(intent);

        }

        for (int row = 0; row < TicTacToe.NUM_ROWS; row++) {
            for (int col = 0; col < TicTacToe.NUM_COLUMNS; col++) {
                if (view.getId() == buttons[row][col].getId()) {
                    game.onClickPosition(row, col);
                }
                buttons[row][col].setText(
                        game.stringForButtonAtLocation(row, col));
            }

        }
        feedback.setText(game.getState());


    }

    public String xScore() {

        String xScore = "X: "+ p1.getText().toString() +" has " + game.getXCount() + " points\n";

       return xScore;


    }

    public String oScore() {
        String oScore = "O: "+ p2.getText().toString() +" has " + game.getOCount() + " points\n";

        return oScore;
    }

}




