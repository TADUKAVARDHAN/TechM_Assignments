package org.bhanu;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;
public class StreamEx1 {
	String words="Hello India. I am V.Bhanu Prakash";
	String fname="src//org//bhanu//f1.txt";
	try(PrintWriter(Files.newBufferedWriter(
			Paths.get(fname)))){
		
	}
}
