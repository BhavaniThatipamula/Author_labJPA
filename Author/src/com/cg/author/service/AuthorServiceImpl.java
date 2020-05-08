package com.cg.author.service;

import com.cg.author.bean.Author;
import com.cg.author.dao.AuthorDao;
import com.cg.author.dao.AuthorDaoImpl;

public class AuthorServiceImpl implements AuthorService{
	
	
	AuthorDao authorDao=new AuthorDaoImpl();

	@Override
	public boolean addAuthor(Author author) {
		
		boolean flag=authorDao.addAuthor(author);
		
		return flag;
	}

	@Override
	public Author updateAuthor(Author author) {
		Author newAuthor=authorDao.updateAuthor(author);
		return newAuthor;
	}

	@Override
	public boolean deleteAuthor(int id) {
		Author author=authorDao.findAuthor(id);
		boolean flag=false;
		if(author!=null)
		{
			flag=authorDao.deleteAuthor(author);	
		}
		
		return flag;
	}

	@Override
	public Author findAuthor(int id) {
		Author author=authorDao.findAuthor(id);
		
			return author;
		

	}

}
