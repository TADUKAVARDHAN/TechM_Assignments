package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpDetails {
	private Integer id;
	private String name;
	private double sal;
	public EmpDetails() {
		super();
	}
	public EmpDetails(Integer id,String name,double sal) {
		this.id=id;
		this.name=name;
		this.sal=sal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal=sal;
	}
	public String toString() {
		return "Employee[id:"+id+", name:"+name+", sal:"+sal+"]";
	}
}
