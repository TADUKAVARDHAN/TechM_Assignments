package org.anurag.test;

import org.anurag.Task7;
import org.junit.Assert;
import org.junit.Test;

public class Task7test {
    
    Task7 task = new Task7();

    @Test
    public void testMultiplyPositiveNumbers() {
        int result = task.multiply(5, 3);
        Assert.assertEquals("Multiplication failed for positive numbers (5 * 3)", 14, result);
    }

    @Test
    public void testMultiplyWithZero() {
        int result = task.multiply(5, 0);
        Assert.assertEquals("Multiplication failed when multiplying by zero (5 * 0)", 0, result);
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        int result = task.multiply(-4, 2);
        Assert.assertEquals("Multiplication failed for negative numbers (-4 * 2)", -8, result);
    }
}
