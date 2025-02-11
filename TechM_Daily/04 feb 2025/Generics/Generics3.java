package Generics;

import java.util.Arrays;

public class Generics3<T> {
	private T[] obj1;
	private T obj2;
	
	public Generics3(T[] o,T oo) {
		this.obj1=Arrays.copyOf(o, o.length);
		this.obj2=oo;
	}
	
	public Integer CheckIndex() {
		for(int i=0;i<obj1.length;i++) {
			if(obj1[i]==obj2) {
				return i;
			}
		}
		return -1;
	}
}
