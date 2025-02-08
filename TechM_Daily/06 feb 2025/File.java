package org.bhanu;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
public class File {
	private static List<String> filterAndConvertToUpper(Stream<String> stream,int length){
		return stream.filter(s->s.length()>length).map(String::toUpperCase).collect(Collectors.toList());
	}
	public static void main(String arg[]) {
		String fname="src/org/bhanu/f1.txt";
		try(Stream <String> lines=Files.lines(Paths.get(fname))){
			List<String> l=filterAndConvertToUpper(lines,15);
			System.out.println("Filtered string with length 5(converted to Upper Case)"+l);
		}
		catch(IOException e) {
			System.out.println("IO Exception occured");
		}
	}
}
