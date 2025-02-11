package session_1;

import java.util.Arrays;

public class Task_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[][]= {{1,2,3},{4,5}};
		int arr2[][]= {{1,2,3},{4,5}};
		
		Object[] arr4= {arr1};
		Object[] arr5= {arr2};
		System.out.println(Arrays.deepEquals(arr4, arr5));
		
		System.out.println(Arrays.equals(arr4, arr5));
	}

}
