package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMultiplication {
    @Test
    public void test1(){
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        Assertions.assertEquals(10,product.amount);
        product = five.times(3);
        Assertions.assertEquals(15,product.amount);
    }

}