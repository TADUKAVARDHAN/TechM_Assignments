package Task3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class RunnerClass {
	
	public static void main(String args[]) {
		Resource res = new ClassPathResource("invetory.xml");
		@SuppressWarnings("deprecation")
		//invoking the xml file.
		BeanFactory factory = new XmlBeanFactory(res);
		//calling the bean component
		Inventory_class obj = (Inventory_class)factory.getBean("idq");
		obj.display();
		
	}

}
