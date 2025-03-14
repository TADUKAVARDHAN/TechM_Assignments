package com.tasks;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class Task2_execution {
	
	public static void main(String args[]) {
		 //include the xml file
		Resource res = new ClassPathResource("task2.xml");
		@SuppressWarnings("deprecation")
		//invoking the xml file.
		BeanFactory factory = new XmlBeanFactory(res);
		//calling the bean component
		Task2 empObj = (Task2)factory.getBean("Task12");
		empObj.displayd();
	}

}
