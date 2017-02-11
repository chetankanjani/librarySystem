package com.librarySystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.librarySystem.Book;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome" );
        BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
        
    	ApplicationContext appContext = 
        		new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	
    	SystemInterfaceImplementation bo=(SystemInterfaceImplementation)appContext.getBean("bookBo");
    	
    	List<Book> l=new ArrayList<Book>();
		l=(List<Book>) bo.viewBooks();
		
		Iterator itr=l.iterator();  
		  while(itr.hasNext()) {
			  Book b= (Book) itr.next();
			  
		   System.out.println(b.getId()+"\t"+b.getName()+"\t"+b.getCategory()+"\t"+b.getAuthor()+"\t"+b.getDescription());  
		  }
    }
}
