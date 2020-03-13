package com.example.exercicecours1;

import java.util.Random;

public class CompareNumber {

    public enum guessState{BIGGER, EQUAL, SMALLER}



    public guessState compareNumberToNumber(int numberOne, int numberTwo) {
        guessState numberState;
        if (numberOne < numberTwo) {
            numberState = guessState.SMALLER;
        } else if (numberOne > numberTwo) {
            numberState = guessState.BIGGER;
        }else {
            numberState = guessState.EQUAL;
        }
        return numberState;
    }



}
