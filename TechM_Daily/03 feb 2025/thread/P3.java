package threads;

import java.util.Arrays;

class SortThread extends Thread {
    private int[] array;

    public SortThread(int[] array) {
        this.array = array;
    }

    public void run() {
        Arrays.sort(array);
    }

    public int[] getSortedArray() {
        return array;
    }
}

public class P3 {
    public static void main(String[] args) {
        int[] array = { 7, 2, 9, 1, 5, 3 };
        System.out.println("Before Sorting:");
        for(int i:array) {
        	System.out.print(i+" ");
        }

        SortThread sortThread = new SortThread(array);
        sortThread.start();

        try {
            sortThread.join(); 
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
        System.out.println("\n\nAfter Sorting:");
        for(int i:sortThread.getSortedArray()) {
        	System.out.print(i+" ");
        }
    }
}
