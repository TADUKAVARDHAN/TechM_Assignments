package Generics;

public class task2 {
public static void main(String[] args) {
	Integer[] arr1 = {1,2,3,4,5};
	Double[] arr3 = {2.67, 4.67,1.78,2.12,5.0};//2 4 1 2 5
	Generics2<Integer> ob=new Generics2<>(arr1);
	Integer[] arr2=ob.Sum();
	System.out.println("Sum of even no is: "+arr2[0]+" Sum of odd no is:"+arr2[1]);
	
	Generics2<Double> ob1=new Generics2<>(arr3);
	Integer[] arr4=ob1.Sum();
	System.out.println("Sum of even no is: "+arr4[0]+" Sum of odd no is:"+arr4[1]);
}
}