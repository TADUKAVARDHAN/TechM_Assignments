package Task2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import dependancyInjaction_constructors.emp;

public class LoanRunner {
	public static void main(String args[]) {
		
		Resource res = new ClassPathResource("loan.xml");
		@SuppressWarnings("deprecation")
		//invoking the xml file.
		BeanFactory factory = new XmlBeanFactory(res);
		//calling the bean component
		Loan_Class empOb = (Loan_Class)factory.getBean("loan");
		empOb.display();
	 
	
	}
	

}
