package org.anurag.test;

import org.anurag.Task5;
import org.junit.Test;

public class Task5test {
    
    Task5 task = new Task5();

    // Test fails if method takes longer than 1000ms
    @Test(timeout = 1000)
    public void testLongRunningMethod() {
        task.longRunningMethod(); // Should complete within 1000ms
    }
}
