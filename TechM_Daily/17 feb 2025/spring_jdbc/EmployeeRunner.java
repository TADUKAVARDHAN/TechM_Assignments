package com.jdbc.spring;

 

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeRunner {
public static void main(String args[]) {
	//include the XML file
	@SuppressWarnings("resource")
	ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
	//inclusion of DAO file
	EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
	//insert query
	
//	int status=dao.saveEmployee(new Employee(120,"sandeep",95000));
//	System.out.println("Row Inserted Successfully" +status);
	//try to insert multiple row/s into the table using jdbctemplate.
	
	//deletion of row/s from the table.
	
//	Employee e=new Employee();
//	e.setId(102);
//	int status1=dao.deleteEmployee(e);
//	System.out.println(status1);
	
	//update query
	int status=dao.updateEmployee(new Employee(121,"santhosh",85000));
	System.out.println("Row updated Successfully" +status);
	
	
	
  }
}
