package com.cg.author.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.author.bean.Author;

public class AuthorDaoImpl implements AuthorDao{
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public boolean addAuthor(Author author) {
		try {
			em.getTransaction().begin();
			em.persist(author);
			em.getTransaction().commit();
			return true;}
				catch(Exception e) {
					e.printStackTrace();
					return false;
			}
	}
  
	@Override
	public boolean deleteAuthor(Author author) {
		
		boolean flag=false;
		try {
		 flag=em.contains(author);
		 if(flag)
		 {
		
			em.remove(author);
			 
		 }}
		catch(Exception e) {
			e.printStackTrace();
			
		}
			return flag;		
	}
	@Override
	public Author updateAuthor(Author author) {
		try {
			Author temp = findAuthor(author.getAuthorId());
			temp.setFirstName(author.getFirstName());
			temp.setLastName(author.getLastName());
			temp.setMiddleName(author.getMiddleName());
			temp.setPhoneNo(author.getPhoneNo());
			return temp;
		}catch(Exception e) {
				e.printStackTrace();
				return null;
			
		}
	}
	@Override
	public Author findAuthor(int id) {

		return em.find(Author.class, id);
	}

}
