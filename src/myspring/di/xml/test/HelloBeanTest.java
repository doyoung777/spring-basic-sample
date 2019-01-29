package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {
	
	public static void main(String[] args) {
		// 1. Create IoC Container
		ApplicationContext context = new GenericXmlApplicationContext("classpath:config/beans.xml");
		
		// 2. Get Hello Bean
		Hello hello = (Hello) context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		
		// 3. Get StringPrinter Bean
		Printer printer = (Printer) context.getBean("printer", Printer.class);
		System.out.println(printer.toString());
		
		// 4. Verify IoC Container's configuration (singleton)
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
	}
}
