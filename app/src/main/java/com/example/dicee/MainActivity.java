package com.example.dicee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    int turn = 0;
    int totalLeft = 0;
    int totalRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton, skipButton;
        rollButton = (Button) findViewById(R.id.rollButton);
        skipButton = (Button) findViewById(R.id.skipButton);
        final ImageView left_dice = (ImageView) findViewById(R.id.leftDice);
        final ImageView right_dice = (ImageView) findViewById(R.id.rightDice);
        final int[] diceArray ={
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "onClick: Button has been clicked");

                Random randomNumberGenerator = new Random();
                int numberLeft = randomNumberGenerator.nextInt(6);
                int numberRight = randomNumberGenerator.nextInt(6);
                int totalNumber;
                //Log.d(TAG, "onClick: number= " + number);
                left_dice.setImageResource(diceArray[numberLeft]);
                right_dice.setImageResource(diceArray[numberRight]);
                final TextView left_score = (TextView) findViewById(R.id.leftScore);
                final TextView right_score = (TextView) findViewById(R.id.rightScore);
                numberLeft += 1;
                numberRight += 1;
                totalNumber = numberLeft + numberRight;
                if ( totalNumber == 5 || totalNumber == 7 || totalNumber == 9 || totalNumber ==11){
                    totalNumber -= 2*(numberLeft + numberRight);
                }
                if (turn % 2 == 0){
                    totalLeft += totalNumber;
                    String total = Integer.toString(totalLeft);
                    left_score.setText(total);
                    turn += 1;
                }
                else {
                    totalRight += totalNumber;
                    String total = Integer.toString(totalRight);
                    right_score.setText(total);
                    turn += 1;
                }
            }
        });


        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn += 1;
            }
        });


    }


}
