package org.anurag.test;
import org.anurag.Task2;
import org.junit.Test;

public class Task2test {

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Task2 task = new Task2();
        task.divide(5, 0); 
    }
}
