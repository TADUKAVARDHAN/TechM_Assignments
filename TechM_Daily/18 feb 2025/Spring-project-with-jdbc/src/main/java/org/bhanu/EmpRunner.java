package org.bhanu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class EmpRunner {
	public static void main(String arg[]) {
		ApplicationContext a=new ClassPathXmlApplicationContext("config.xml");
		EmpDao ed=(EmpDao)a.getBean("edao");
		int status=ed.saveEmployee(new Empdetails(2,"Bhanu",56000));
		System.out.println("Row inserted successfully "+status);
		status=ed.updateEmployee(new Empdetails(1,"Srinivasulu",76000));
		System.out.println("Row updated successfully "+status);
		status=ed.deleteEmployee(new Empdetails(2));
		System.out.println("Row deleted successfully "+status);
		((ClassPathXmlApplicationContext) a).close();
	}
}
