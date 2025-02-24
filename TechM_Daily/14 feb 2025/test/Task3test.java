package org.anurag.test;

import org.anurag.Task3;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class Task3test {

    private Task3 task;

    @Before
    public void setUp() {
        System.out.println("Setting up before test...");
        task = new Task3(); 
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up after test...");
        task = null; 
    }

    @Test
    public void testAdd() {
        int result = task.add(3, 2);
        assertEquals(5, result);
        System.out.println("result is "+result);
    }
}
