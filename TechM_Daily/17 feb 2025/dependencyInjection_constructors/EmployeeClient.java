package dependancyInjaction_constructors;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import example.Employee;

public class EmployeeClient {
public static void main(String args[]) {
    //include the xml file
	Resource res = new ClassPathResource("emp.xml");
	@SuppressWarnings("deprecation")
	//invoking the xml file.
	BeanFactory factory = new XmlBeanFactory(res);
	//calling the bean component
	emp empObj = (emp)factory.getBean("emp1");
	empObj.display();
}
}

