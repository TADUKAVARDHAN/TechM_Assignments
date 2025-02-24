package org.anurag.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.anurag.Task1;

public class Task1test {

    @Test
    public void testAddNumbers() {
        Task1 t = new Task1();
        int result = t.Product(5, 3);
        
        // Assert that the method returns the expected value
        assertEquals("5 * 3 should equal 15", 15, result);
    }
}
