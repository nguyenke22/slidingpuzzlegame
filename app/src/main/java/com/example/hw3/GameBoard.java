package com.example.hw3;

import android.graphics.Color;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
    Button[][] buttons;
    public static final int GAME_DIMENSION = 4;
    private final String EMPTY_TILE = "";
    ArrayList<String> numbers;
    public GameBoard(){
        buttons = new Button[GAME_DIMENSION][GAME_DIMENSION];
        numbers = new ArrayList<String>();
        /*initalizing array list is useful because I want to manipulate the array size*/
        for(int i = 1; i <= 15; i++){
            numbers.add(Integer.toString(i));
        }
        numbers.add("");
    }
    public boolean isSolved() {
        //boolean isSolved = true;
        for(int i = 0 ; i < GAME_DIMENSION; i++ ) {
            for(int j = 0; j < GAME_DIMENSION; j++) {
                /*if(!buttons[i][j].getText().toString().equals(Integer.toString(i + j +1))
                        && (i + j) != (GAME_DIMENSION -1))*/
                for(int k = 1;k < 15; k++)
                {
                    System.out.println(i + j + k);
                    if(buttons[i][j].getText().toString().equals(Integer.toString(k)))
                    {
                       if( buttons[3][2].getText().toString().equals("15"))

                       //checks the first 14 boxes comparing to array, but for the last 15 it checks for the spot
                       {
                           if(buttons[3][3].getText().toString().equals("")){

                               //empty lower right is empty then its solved 
                        return true;}
                    }}
                    else{
                        return false;
                    }
                }
                {
                    return false;

                }
            }
        }
        for(int i = 0 ; i < GAME_DIMENSION; i++ ) {
            for(int j = 0; j < GAME_DIMENSION; j++) {
                buttons[i][j].setBackgroundColor(Color.CYAN);
                /*allows the player to know that they won the game */
            }
        }
        return true;
    }
    public void addButton(Button b, int i, int j){
        buttons[i][j] = b;
    }
    //check space surrounding
    //can make move if next an empty space

    public boolean checkEmpty(int i, int j) { // i and j represent the current node
        Button currentB = buttons[i][j];
        if(i > 0){
            //check above current node
            Button upperB = buttons[i - 1][j];
            if(isEmpty(upperB)){
                swap(currentB,upperB);
                return true;
            }

        }
        if(j > 0){
            //checks the left
            Button leftB = buttons[i][j - 1];
            if(isEmpty(leftB)){
                swap(currentB,leftB);
                return true;
            }
        }
        if(j < GAME_DIMENSION - 1){
            //checks the right
            Button rightB = buttons[i][j+1];
            if(isEmpty(rightB)){
                swap(currentB,rightB);
                return true;
            }
        }
        if(i < GAME_DIMENSION - 1){
            //checks the box below
            Button lowerB = buttons[i + 1][j];
            if(isEmpty(lowerB)){
                swap(currentB, lowerB);
                return true;
            }
        }
        return false;

    }
    private void swap(Button b1, Button b2){
        CharSequence temp = b1.getText();
        b1.setText(b2.getText());
        b2.setText(temp);
        System.out.print ("help me" + isSolved());
        if (isSolved()){
            for(int k = 0; k < GAME_DIMENSION; k++)
                for (int j = 0; j< GAME_DIMENSION; j++)
                buttons[k][j].setBackgroundColor(Color.CYAN);
        //if square is empty we swap
        }


    }
    private boolean isEmpty(Button b){
        return b.getText().toString().equals(EMPTY_TILE);
    }
    public void shuffle(){
        Collections.shuffle(numbers);
        int w = 0;
        for(int i = 0; i < GAME_DIMENSION; i++){
            for(int j = 0; j< GAME_DIMENSION; j++){
                buttons[i][j].setText(numbers.get(w));
                //changing what the button text is
                buttons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                //setting background color


                w++;
            }
        }
    }
}

