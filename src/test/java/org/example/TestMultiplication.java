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

    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);
        Expression result  = five.plus(five);
        Sum sum =(Sum)result;
        Assertions.assertEquals(five,sum.augend);
        Assertions.assertEquals(five,sum.addend);

    }

    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum,"USD");
        Assertions.assertEquals(Money.dollar(7),result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1),"USD");
        Assertions.assertEquals(Money.dollar(1),result);

    }
    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2),"USD");
        Assertions.assertEquals(Money.dollar(1),result);
    }

    @Test
    public void testIdentityRate(){
        Assertions.assertEquals(1,new Bank().rate("USD","USD"));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);


    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs). plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs). times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    @Test
    public void testPlusSameCurrencyReturnsMoney() {
        Expression sum = Money.dollar(1). plus(Money.dollar(1));
        assertTrue(sum instanceof Money);
    }





}

