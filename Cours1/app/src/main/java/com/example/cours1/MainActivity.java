package com.example.cours1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int max = 10;
    private GuessNumber guesseNumber;

    private EditText inputNumber;
    private Button buttonTry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.editText_guessedNumber);
        buttonTry = findViewById(R.id.button_TryNumber);

        guesseNumber = new GuessNumber(max);
        setListenner();
    }

    private void setListenner() {
        buttonTry.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }

    private void guess() {
        int numberToGuess = Integer.parseInt(inputNumber.getText().toString());
         GuessNumber.guessState result = guesseNumber.testNumber(numberToGuess);

         if (result == GuessNumber.guessState.BIGGER) {
             showHint("Votre nombre est plus grand");
         } else if (result == GuessNumber.guessState.SMALLER) {
             showHint("Votre nombre est plus petit");
         } else {
             showHint("Bravo !, un nouveau nombre a été généré.");
             guesseNumber.generateNumber();
         }
    }

    private void showHint(String hint) {
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }
}
