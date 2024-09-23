package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dollar extends Money{
    Dollar (int amount){
        this.amount = amount;
    }

    Money times(int multiplier){
        return new Dollar(amount * multiplier);

    }
    public static void main(String[] args) {

    }
}