package Task4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

 

public class App_runner {
	public static void main(String args[]) {
		Resource res = new ClassPathResource("idp.xml");
		@SuppressWarnings("deprecation")
		//invoking the xml file.
		BeanFactory factory = new XmlBeanFactory(res);
		//calling the bean component
		Shopping_app obj = (Shopping_app)factory.getBean("ids");
		obj.printl();
		
	}
}
 