package example; 
	import org.springframework.beans.factory.*;
	import org.springframework.beans.factory.xml.*;
	import org.springframework.core.io.*;

	public class RunnerClass {
	public static void main(String args[]) {
		//include the XML file
		Resource res= new ClassPathResource("config.xml");
		@SuppressWarnings("deprecation")
		//invoke the xml bean
		BeanFactory factory = new XmlBeanFactory(res);
		//call the getter methods of the bean
		Employee emp = (Employee)factory.getBean("empBean");
		emp.display();
		 
		
	}

}
