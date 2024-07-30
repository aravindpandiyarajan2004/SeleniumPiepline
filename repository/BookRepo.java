package com.aravind.micro.repository;

import java.util.List;

import com.aravind.micro.model.Book;

public interface BookRepo  {
		public void save(Book book);
		public void update(Book book);
		public void delete(int bid);
	    public List<Book> findAllBooks();
	    public Book findById(int bid);	
		
}
