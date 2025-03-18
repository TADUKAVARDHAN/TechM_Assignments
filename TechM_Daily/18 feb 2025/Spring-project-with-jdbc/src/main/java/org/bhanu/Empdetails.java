package org.bhanu;

public class Empdetails {
	private int id;
	private String name;
	private int sal;
	public Empdetails(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }
    public Empdetails(int id) {
        this.id = id;
    }
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setSal(int sal) {
		this.sal=sal;
	}
	public int getSal() {
		return sal;
	}
}
