package com.tasks;

public class Task1 {
	//6) Create a spring dependency application for Student Bean which should include setter/getter, constructor and interface injection.
	
		private int id;
		private String name;
		private String branch;
		
		
	public void setid(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setBranch(String branch) {
		this.branch=branch;
	}
	public int getId() {
		return id;
	}
	public String getname() {
		return name;
	}
	public String getBranch() {
		return branch;
	}
	public void display() {
		System.out.print("name of student is "+name +"  id is "+id+"  branch is "+branch);
	}

}
