package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMultiplication {
    @Test
    public void test1(){
        Dollar five = new Dollar(5);
        five.times(2);
        Assertions.assertEquals(10,five.amount);
    }

}