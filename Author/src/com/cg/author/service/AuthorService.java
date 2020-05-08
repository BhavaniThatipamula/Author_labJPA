package com.cg.author.service;

import com.cg.author.bean.Author;

public interface AuthorService {
	
	
	public boolean addAuthor(Author author);
	public Author updateAuthor(Author author);
	public boolean deleteAuthor(int id);
	public Author findAuthor(int id);

}
