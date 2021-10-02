
/**
 * CS 333 Homework 3 
 * @author Kelly Nguyen
 */
package com.example.hw3;

import android.view.View;

public class ResetListener implements View.OnClickListener{
    private GameBoard gameBoard ;
    public ResetListener(GameBoard b){
        gameBoard = b;
    }
    @Override
    public void onClick(View v) {
        gameBoard.shuffle();
    }
}
