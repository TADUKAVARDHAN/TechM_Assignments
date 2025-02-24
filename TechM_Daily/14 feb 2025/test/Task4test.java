package org.anurag.test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.anurag.Task4;

@RunWith(Parameterized.class)
public class Task4test {
	int input;
	boolean expected;
	
	public Task4test(int a, boolean expected) {
		this.input=a;
		this.expected=expected;
	}
	
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {2, true},  // 2 is even → expected true
            {5, false}, // 5 is odd → expected false
            {10, true}, // 10 is even → expected true
            {7, false}, // 7 is odd → expected false
            {0, true}   // 0 is even → expected true
        });
    }
    
    @Test
    public void testIsEven() {
        Task4 task = new Task4();
        Assert.assertEquals(expected, task.evenorodd(input));
    }
}
