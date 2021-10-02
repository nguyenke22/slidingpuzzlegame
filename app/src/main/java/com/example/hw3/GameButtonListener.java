package com.example.hw3;

import android.view.View;

public class GameButtonListener implements View.OnClickListener {
    private int posI;
    private int posJ;
    private GameBoard gameBoard;
    public GameButtonListener(GameBoard b, int i, int j) {
        posI = i;
        posJ = j;
        gameBoard = b;
    }
    @Override
    public void onClick(View v) {
        if(!gameBoard.checkEmpty(posI,posJ)){
            //change the button to pink
        };
        System.out.println("Button at Position i: " + posI +" Position j: " + posJ);
        if(gameBoard.isSolved()){
            //add colors to the board

        }

    }
}
