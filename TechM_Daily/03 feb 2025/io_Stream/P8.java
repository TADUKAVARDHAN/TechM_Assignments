package io_streams;

import java.io.File;

public class P8 {

    public static void main(String[] args) {
        File file = new File("src//exceptions");
        if (file.exists()) {
        	long fileSize = file.length();
            System.out.println((double) fileSize + " Bytes");
            System.out.println((double) fileSize / 1024 + "  KB");
            System.out.println((double) fileSize / (1024 * 1024) + " MB");
        } else
            System.out.println("File does not exist");
    }

}
