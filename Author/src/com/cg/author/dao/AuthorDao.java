package com.cg.author.dao;

import com.cg.author.bean.Author;

public interface AuthorDao {

	
	public boolean addAuthor(Author author);
	public boolean deleteAuthor(Author author);
	public Author updateAuthor(Author author);
	public Author findAuthor(int id);
}
