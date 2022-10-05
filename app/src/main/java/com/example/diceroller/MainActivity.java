package com.example.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.button);

        //on click button func
        rollButton.setOnClickListener(v -> rollDice());

        // first open APP
        rollDice();
    }

    // show random dice image
    @SuppressLint("SetTextI18n")
    public void rollDice() {
        Dice dice = new Dice(6);
        int diceRoll = dice.roll(dice.numSides);

        ImageView diceImage = findViewById(R.id.imageView);
        if (diceRoll == 1) {
            diceImage.setImageResource(R.drawable.dice_1);
        }
        else if (diceRoll == 2){
            diceImage.setImageResource(R.drawable.dice_2);
        }
        else if(diceRoll == 3){
            diceImage.setImageResource(R.drawable.dice_3);
        }
        else if(diceRoll == 4){
            diceImage.setImageResource(R.drawable.dice_4);
        }
        else if(diceRoll == 5){
            diceImage.setImageResource(R.drawable.dice_5);
        }
        else {
            diceImage.setImageResource(R.drawable.dice_6);
        }

    }
}
//dice roller function
class Dice{
    int numSides;
    public Dice(int numSides){
        this.numSides = numSides;
        roll(numSides);
    }

    public int roll(int numSides) {
        Random random = new Random();
        return random.nextInt(numSides);
    }

}
