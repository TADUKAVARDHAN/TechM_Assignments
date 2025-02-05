package io_streams;

import java.io.File;
import java.io.FilenameFilter;

public class P2 {
    public static void main(String a[]) {
        File directory = new File("src//exceptions");
        String[] files = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".txt")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (String file : files) {
            System.out.println(file);
        }
    }
}

