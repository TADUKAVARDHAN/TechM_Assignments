package org.anurag;

public class Task8 {
    // Private method
    private int square(int num) {
        return num * num;
    }

    // Public method calling private method
    public int getSquare(int num) {
        return square(num);
    }
}
