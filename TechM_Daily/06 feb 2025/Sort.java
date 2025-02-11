package org.bhanu;
import java.util.*;
import java.util.stream.*;
public class Sort {
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
		List<String> l=Collections.list(st).stream().map(token->(String)token).sorted().collect(Collectors.toList());
		System.out.print(l);
	}
}
