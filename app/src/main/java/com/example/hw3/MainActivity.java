package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private GameBoard gameBoard;
    public static final int[] BUTTON_IDS = {
            R.id.button1, //repeat this for button1 to button16
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button10,
            R.id.button11,
            R.id.button12,
            R.id.button13,
            R.id.button14,
            R.id.button15,
            R.id.button16,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getUserTypeOnButtonClick();
        int w = 0;
        gameBoard = new GameBoard();
        findViewById(R.id.buttonReset).setOnClickListener(new ResetListener(gameBoard));
        for(int i = 0; i < GameBoard.GAME_DIMENSION; i++) {
            for(int j = 0; j < GameBoard.GAME_DIMENSION; j++)
            {
                Button b = findViewById(BUTTON_IDS[w]);
                w++;
                b.setTextSize(15);
                GameButtonListener listener = new GameButtonListener(gameBoard,i,j);
                b.setOnClickListener(listener);
                try {

                    gameBoard.addButton(b,i,j);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                //button ID in array, to get object off of ID


            }




        }

    }


}