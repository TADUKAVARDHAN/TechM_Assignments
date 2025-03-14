package example;

public class Employee {
	
	private int id;
	private String name;
	private String city;
	
	public void setId(int id) {
		this.id=id;
	}

	public void setName(String name) {
		this.name=name;
	}

	public void setCity(String city) {
		this.city=city;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	
	public  void display() {
		System.out.println("name is "+ name + "  id is "+id+ "  city is  "+city);
	}
 
	 
}
