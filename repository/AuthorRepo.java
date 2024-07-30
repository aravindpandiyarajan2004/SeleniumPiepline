package com.aravind.micro.repository;

import java.util.List;


import com.aravind.micro.model.Author;


public interface AuthorRepo  {
	
	public void save(Author au);
	public void update(Author au);
	public void delete(int aid);
	
    public List<Author> findAllAuthors();

   
	public List<Integer> getIdList();
	
	
	
    public Author findById(int aid);

}
