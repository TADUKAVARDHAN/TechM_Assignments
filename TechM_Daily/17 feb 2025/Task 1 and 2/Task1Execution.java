package com.tasks;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import dependancyInjaction_constructors.emp;

public class Task1Execution {
	public static void main(String args[]) {
	    //include the xml file
		Resource res = new ClassPathResource("task1.xml");
		@SuppressWarnings("deprecation")
		//invoking the xml file.
		BeanFactory factory = new XmlBeanFactory(res);
		//calling the bean component
		Task1 empObj = (Task1)factory.getBean("student1");
		empObj.display();
	}

}
