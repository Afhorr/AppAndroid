package com.example.exercicecours1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CompareNumber compareNumber;

    private EditText inputNumberOne;
    private EditText inputNumberTwo;
    private Button buttonCompare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumberOne = findViewById(R.id.editText_NumberOne);
        inputNumberTwo = findViewById(R.id.editText_NumberTwo);
        buttonCompare = findViewById(R.id.button_Compare);
        setListenner();
    }
    private void setListenner() {
        buttonCompare.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }

    private void guess() {
        int first = Integer.parseInt(inputNumberOne.getText().toString());
        int second = Integer.parseInt(inputNumberTwo.getText().toString());
        // CompareNumber.guessState result = compareNumber.compareNumberToNumber(first,second);
        inputNumberOne.setBackgroundColor(0);
        inputNumberTwo.setBackgroundColor(0);

        if (first > second) {
            showHint("Le nombre un est plus grand");
            inputNumberOne.setBackgroundColor(0xFF00FF00);
            inputNumberTwo.setBackgroundColor(0);
        } else if (first < second) {
            showHint("Le nombre deux est plus grand");
            inputNumberTwo.setBackgroundColor(0xFF00FF00);
            inputNumberOne.setBackgroundColor(0);
        } else {
            showHint("Les deux nombres sont égaux");
        }
    }

    private void showHint(String hint) {
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }
}
