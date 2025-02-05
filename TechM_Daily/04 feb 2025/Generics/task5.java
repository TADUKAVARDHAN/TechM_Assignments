package Generics;

public class task5 {
public static void main(String[] args) {
	
	Integer[] arr1= {10,20,30,40};
	Integer[] arr2= {1,2,3,4};
	
	Generics5<Integer> ob=new Generics5<>(arr1,arr2);
	Integer[] arr3=ob.Check();
	for(int num:arr3) {
		System.out.print(num+ " ");
	}
}
}
