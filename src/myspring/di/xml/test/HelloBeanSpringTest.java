package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;
	
//	@Before
//	public void init() {
//		context = new GenericXmlApplicationContext("config/beans.xml");
//	}

	@Test
	public void testSame() {
		Hello hello1 = (Hello)context.getBean("hello");
		Hello hello2 = (Hello)context.getBean("hello");
		Hello hello3 = (Hello)context.getBean("hello2");
		
		assertSame(hello1, hello2);
		assertNotSame(hello2, hello3);
	}
	
	@Test
	public void testEquals() {		
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		
		Printer printer = (Printer) context.getBean("printer", Printer.class);
		assertEquals("", printer.toString());	
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
