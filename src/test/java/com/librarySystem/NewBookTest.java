package com.librarySystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class NewBookTest extends TestCase {

	SystemInterfaceImplementation i;

	
	@Test
	public void testFindByBook()
	{
		ApplicationContext appContext = 
	    		new ClassPathXmlApplicationContext("ApplicationContext.xml");
	    	//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    	 i = (SystemInterfaceImplementation)appContext.getBean("SystemInterfaceImplementation");
		Book input = new Book();
		input.setName("New Book");
		input.setAuthor("new author");
		input.setQty(1);
		Book result=null;
		try {
			result = i.findByBook("java");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(input.getBookId(),result.getBookId());
	}
}
