package Generics;

import java.util.Arrays;

public class Generics1 <T> {
	private T[] obj1;
	private T[] obj2;
	
	public Generics1(T[] o,T[] oo) {
		this.obj1=Arrays.copyOf(o,o.length);
		this.obj2=Arrays.copyOf(oo,oo.length);
	}
	public boolean Check() {
		return Arrays.equals(obj1, obj2);
	}
}
