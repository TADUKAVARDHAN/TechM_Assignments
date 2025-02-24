package org.anurag;

public class Task5 {
    // A method that simulates a delay
    public void longRunningMethod() {
        try {
            Thread.sleep(1500); // Simulates a 500ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
