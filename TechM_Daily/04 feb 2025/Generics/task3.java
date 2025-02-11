package Generics;

public class task3 {
	public static void main(String[] args) {
		Integer[] arr= {10,30,20,40,20};
		Integer a=20;
		Generics3<Integer> ob=new Generics3<>(arr,a);
		System.out.println("The index of the first occurrence of the target element is: "+ob.CheckIndex());
	}
}
