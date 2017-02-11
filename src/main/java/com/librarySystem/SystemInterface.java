package com.librarySystem;

import java.util.List;

public interface SystemInterface {
	
	public void newBook(Book b);

	public void deleteBook(Book b);

	public List<Book> viewBooks();

	public void issueBook(RentBooks r);

	public void returnBook(RentBooks r);
	
	public void newUser(User b);

	public void removeUser(User b);
	
	public boolean loginUser(User b);	

	public boolean loginAdmin(Admin b);
	
	public void updateBookCategory(Book b,String cat);
	
	public List<Book> viewBooksByCategory(String cat);
	
	public List<Book> viewBooksByName(String name);
	
	public List<Book> viewBooksByAuthor(String author);
	
	public List<User> viewUsers();
	
	public void UpdateQuantity(Book b,int n);
	
	public boolean CheckBookAvailability(Book b);
	
	public void ChangeAvailability(Book b,int n);
}
