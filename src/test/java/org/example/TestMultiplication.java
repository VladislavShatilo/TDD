package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMultiplication {
    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        Assertions.assertEquals(Money.dollar(10),five.times(2));
        Assertions.assertEquals(Money.dollar(15),five.times(3));
    }


    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency(){
        Assertions.assertEquals("USD",Money.dollar(1).currency());
        Assertions.assertEquals("CHF",Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition(){

        Money five = Money.dollar(5);
        Expression sum =  five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum,"USD");
        Assertions.assertEquals(Money.dollar(10),reduced);
    }



}

