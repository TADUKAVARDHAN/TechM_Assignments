package Generics;

public class task4 {
public static void main(String[] args) {
	
	Integer[] arr= {1,2,3,4,5};
	Generics4<Integer> ob=new Generics4<>(arr);
	Integer[] arr1=ob.reverseList();
	System.out.println("Reversed list is: ");
	for(int num:arr1) {
		System.out.println(num+" ");
	}
	
	String[] arrs= {"hi","haha","neha"};
	Generics4<String> obs=new Generics4<>(arrs);
	String[] arr1s=obs.reverseList();
	System.out.println("Reversed list is: ");
	for(String num:arr1s) {
		System.out.println(num+" ");
	}
	
}
}
