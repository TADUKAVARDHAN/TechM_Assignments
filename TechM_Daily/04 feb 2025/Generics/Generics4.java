package Generics;

import java.util.Arrays;

public class Generics4<T> {
	private T[] obj1;
	
	public Generics4(T[] o) {
		obj1=Arrays.copyOf(o, o.length);
	}
	
	public T[] reverseList() {
		T[] obj2=Arrays.copyOf(obj1, obj1.length);
		int j=0;
		for(int i=obj1.length-1;i>=0;i--) {
			obj2[j]=obj1[i];
			j++;
		}
		return obj2;
	}
}
