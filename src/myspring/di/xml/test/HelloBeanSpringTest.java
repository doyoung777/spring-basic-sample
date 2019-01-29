package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;

	@Test
	public void testSame() {
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = (Hello)context.getBean("hello");
		
		// true -> singleton
		assertSame(hello, hello2);
	}
	
	@Test @Ignore
	public void testEquals() {
		
		// 2. Get Hello Bean
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		
		// 3. Get StringPrinter Bean
		Printer printer = (Printer) context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
		
	}
}
