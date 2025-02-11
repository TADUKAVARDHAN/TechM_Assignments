package techm;
import java.util.*;
public class dataTrasmission {
 	public static void main(String[] args) {
			
	     Scanner sc=new Scanner(System.in);
	     String s=sc.nextLine();
	     s=s.substring(0, s.length()-1);
	     String h[]=s.split("\\s+");
	     List<Integer> l=new ArrayList<Integer>();
	     for(int i=0;i<h.length;i++)
	     {
	    	 int g=Integer.parseInt(h[i]);
	    	 if(isprime(g))
	    		 l.add(g);
	     }
	     Collections.sort(l);
	     int k=0;
	     if(l.size()>0 && l.size()>=2)
	    	 k=l.size()+l.get(l.size()-2);
	     System.out.println(k);
		}
	    public static boolean isprime(int n)
	    {
	    	if(n<=1)
	    		return false;
	    	for(int i=2;i<=n/2;i++)
	    	{
	    		if(n%i==0)
	    			return false;
	    	}
	    	return true;
	    }
	}

