package session_1;

import java.util.Arrays;

public class Array_copy_Alternative_elements {
public static void main(String x[])
{
	int arr1[]= {1,2,3,4,5,6,7,8};
	int arr2[]= {9,10,11,12,13,14,15,16};
	for(int i=0;i<arr1.length;i=i+2)
	{
		System.arraycopy(arr1, i, arr2, i, 1);
	}
	System.out.println(Arrays.toString(arr2));
	
}
}

