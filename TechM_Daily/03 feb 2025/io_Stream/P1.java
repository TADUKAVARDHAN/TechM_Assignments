package io_streams;

import java.io.File;

public class P1 {
    public static void main(String a[]) {
        File directory = new File("src//exceptions");
        String[] files = directory.list();
        for (String name : files) {
            System.out.println(name);
        }
    }
}
