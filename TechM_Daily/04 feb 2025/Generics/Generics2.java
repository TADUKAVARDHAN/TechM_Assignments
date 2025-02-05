package Generics;


import java.util.Arrays;

public class Generics2<T extends Number> {
	private T[] obj;
	
	public Generics2(T[] o) {
		this.obj=Arrays.copyOf(o, o.length);
	}
	
	public Integer[] Sum(){
		int es=0;
		int os=0;
		for(int i=0;i<obj.length;i++) {
			int value = (int) Math.floor(obj[i].doubleValue());
			if(value%2==0) {
				es+=value;
			}
			else {
				os+=value;
			}
		}
		return new Integer[] {es,os};
		
	}
}
