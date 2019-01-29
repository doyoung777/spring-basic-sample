package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	
	ApplicationContext context;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	
	@Test
	//@Ignore
	public void testEquals() {
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		
		Printer printer = (Printer) context.getBean("printer", Printer.class);
		System.out.println(printer.toString());
		assertEquals("", printer.toString());
	}
	
	@Test 
	//@Ignore
	public void testSame() {
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = (Hello)context.getBean("hello");
		
		// true -> singleton
		assertSame(hello, hello2);
	}
	
	@Test
	public void testCollection() {
		
		Hello hello = (Hello) context.getBean("hello3");
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value:list) {
			System.out.println(value);
		}
		
	}
}
