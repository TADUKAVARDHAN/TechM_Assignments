package techm;
import java.util.Scanner;
import java.lang.Math;
public class PerfectSquare {
	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);
		int n=Sc.nextInt();
		int p=(int)Math.sqrt(n);
		System.out.println(p*p == n);
}
}
