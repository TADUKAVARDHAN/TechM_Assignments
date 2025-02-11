package org.bhanu;
import java.util.*;
import java.util.stream.*;
import java.util.StringTokenizer;
public class Count {
	public static void main(String arg[]) {
		String s="""
				Ram went to Shyam for work
				Ram is unavailable
				Hence Shyam when to Hari
				Hari is good guy
				He gave work
				Shyam accepted it joyfully
				""";
		StringTokenizer st=new StringTokenizer(s," \n");
		long x=Collections.list(st).stream().map(token->((String)token).toLowerCase()).filter(str->str.startsWith("s")).count();
		System.out.print(x);
	}
}
