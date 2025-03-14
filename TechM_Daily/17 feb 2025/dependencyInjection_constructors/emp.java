package dependancyInjaction_constructors;

public class emp {
	private int id;
	private String name;
	
	  public emp(int id,String name) {
		 this.id=id;
		 this.name=name;
		 
	 }
	  public  void display() {
		System.out.println("name is "+ name + "  id is "+id);
	}
 
	 
}


