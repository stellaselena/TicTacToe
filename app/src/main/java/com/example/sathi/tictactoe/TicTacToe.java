package com.example.sathi.tictactoe;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import static android.content.ContentValues.TAG;

enum State {
    X_TURN,
    O_TURN,
    X_WIN,
    O_WIN,
    TIE
}

class TicTacToe {

    private State state;
    private int[][] boardArray;
    private Context context;

    static final int NUM_ROWS = 3;
    static final int NUM_COLUMNS = 3;
    private static final int EMPTY = 0;
    private static final int X = 1;
    private static final int O = 2;
    private static int xCount;
    private static int oCount;

    TicTacToe(Context context) {
        this.context = context;
        resetGame();
    }

    void resetGame() {
        this.boardArray = new int[NUM_ROWS][NUM_COLUMNS];
        this.state = State.X_TURN;
    }

    void onClickPosition(int row, int column) {
        if (this.boardArray[row][column] != EMPTY)
            return;
        if (this.state == State.X_TURN) {
            this.boardArray[row][column] = X;
            this.state = State.O_TURN;
        } else if (this.state == State.O_TURN) {
            this.boardArray[row][column] = O;
            this.state = State.X_TURN;
        }
        checkForWin();
    }

    private void checkForWin() {
        if (!(this.state == State.X_TURN || this.state == State.O_TURN))
            return;
        if (checkMarks(X)) {
            this.state = State.X_WIN;
        } else if (checkMarks(O)) {
            this.state = State.O_WIN;
        } else if (isFull()) {
            this.state = State.TIE;
        }
    }

    private boolean isFull() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLUMNS; col++) {
                if (this.boardArray[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkMarks(int mark) {
        boolean allMarked;

        if (this.boardArray[0][0] == mark && this.boardArray[1][1] == mark && this.boardArray[2][2] == mark)
            return true;

        if (this.boardArray[2][0] == mark && this.boardArray[1][1] == mark && this.boardArray[0][2] == mark)
            return true;

        for (int col = 0; col < NUM_COLUMNS; col++) {
            allMarked = true;
            for (int row = 0; row < NUM_ROWS; row++) {
                if (this.boardArray[row][col] != mark) {
                    allMarked = false;
                    break;
                }
            }
            if (allMarked) return true;
        }

        for (int row = 0; row < NUM_ROWS; row++) {
            allMarked = true;
            for (int col = 0; col < NUM_COLUMNS; col++) {
                if (this.boardArray[row][col] != mark) {
                    allMarked = false;
                    break;
                }
            }
            if (allMarked) return true;

        }

        return false;
    }

    String stringForButtonAtLocation(int row, int column) {
        String mark = "";

        if (this.boardArray[row][column] == X) {
            return "X";
        } else if (this.boardArray[row][column] == O) {
            return "O";
        }

        return mark;
    }

    String getState() {
        String state;
        Resources r = this.context.getResources();
        switch (this.state) {
            case X_TURN:
                state = r.getString(R.string.x_turn);
                break;
            case O_TURN:
                state = r.getString(R.string.o_turn);
                break;
            case X_WIN:
                xCount++;
                state = r.getString(R.string.x_win) + " Points earned: " + xCount;
                Log.d(TAG, "getState: x has won " + xCount + " times");
                break;
            case O_WIN:
                oCount++;
                state = r.getString(R.string.o_win)+ " Points earned: " + oCount;
                Log.d(TAG, "getState: o has won " + oCount + " times");

                break;
            default:
                state = r.getString(R.string.tie);
                break;
        }
        return state;
    }

}
