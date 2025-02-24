package org.anurag.test;

import org.anurag.Task9;
import org.junit.Assert;
import org.junit.Test;

public class Task9test {

    @Test
    public void testSingletonInstance() {
        Task9 instance1 = Task9.getInstance();
        Task9 instance2 = Task9.getInstance();

        Assert.assertSame("Both instances should be the same", instance1, instance2);
    }
}
