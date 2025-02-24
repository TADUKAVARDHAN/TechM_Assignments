package org.anurag.test;

import org.anurag.Task8;
import org.junit.Assert;
import org.junit.Test;

public class Task8test {
    
    Task8 task = new Task8();

    @Test
    public void testGetSquare() {
        int result = task.getSquare(4);
        Assert.assertEquals("Square calculation failed!", 16, result);
    }
}
