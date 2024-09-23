package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dollar {
    private int amount ;
    Dollar (int amount){
        this.amount = amount;
    }
    public boolean equals(Object object){
        Dollar dollar = (Dollar)object;
        return amount == dollar.amount;
    }
    Dollar times(int multiplier){
        return new Dollar(amount * multiplier);

    }
    public static void main(String[] args) {

    }
}