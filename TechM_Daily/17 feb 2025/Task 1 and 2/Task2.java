package com.tasks;

public class Task2 {
	
	private int id;
	private String name;
	private String branch;
	
	Task2(int id,String name,String branch){
		this.name=name;
		this.id=id;
		this.branch=branch;
	}
	public void displayd() {
		System.out.print("name of student is "+name +"  id is "+id+"  branch is "+branch +"    using constructor dependancy injection");
	
	}
}
