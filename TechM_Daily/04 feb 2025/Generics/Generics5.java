package Generics;

import java.util.Arrays;

public class Generics5 <T>{
	private T[] obj1;
	private T[] obj2;
	
	public Generics5(T[] o,T[] oo) {
		this.obj1=Arrays.copyOf(o,o.length);
		this.obj2=Arrays.copyOf(oo,oo.length);
	}
	public T[] Check() {
		T[] obj3=Arrays.copyOf(obj1, (obj1.length+obj2.length));
		int i=0;
		int j=0;
		for(int l=0;l<obj3.length;l++) {
			if(l%2==0) {
				obj3[l]=obj1[i];
				i++;
			}
			else {
				obj3[l]=obj2[j];
				j++;
			}
		}
		return obj3;
	}
}
