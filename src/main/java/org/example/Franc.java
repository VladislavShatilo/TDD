package org.example;

public class Franc extends Money{
    Franc (int amount){
        this.amount = amount;
    }

    Money times(int multiplier){
        return new Franc(amount * multiplier);

    }
    public static void main(String[] args) {

    }
}
