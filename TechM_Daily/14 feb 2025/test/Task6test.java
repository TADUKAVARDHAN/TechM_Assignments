package org.anurag.test;

import org.anurag.Task6;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class Task6test {
    
    Task6 task = new Task6();

    @Test
    public void testDivideValid() {
        Assert.assertEquals(5, task.divide(10, 2));
    }

    @Ignore("Skipping because division by zero is not yet handled.")
    @Test
    public void testDivideByZero() {
        task.divide(10, 0); 
    }
}
