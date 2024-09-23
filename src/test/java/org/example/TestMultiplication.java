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
    public void testFrancMultiplication(){
        Franc five = new Franc(5);
        Assertions.assertEquals(new Franc(10),five.times(2));
        Assertions.assertEquals(new Franc(15),five.times(3));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        assertFalse(new Franc(5).equals(Money.dollar(5)));
    }

}

