package com.cg.author.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.author.bean.Author;
import com.cg.author.service.AuthorService;
import com.cg.author.service.AuthorServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		AuthorService authorService=new AuthorServiceImpl();
		int choice=0;
		
		
		while(choice!=4)
		{
	
			System.out.println("1. AddAuthor");
			System.out.println("2. DeleteAuthor");
			System.out.println("3.UpdateAuthor");
			System.out.println("4.exit");
			try {
			System.out.println("Enter the choice");
			choice=scanner.nextInt();
			
		switch(choice)
		{
		case 1: 
			Author author=new Author();
			System.out.println("Enter the first name");
			String firstName=scanner.nextLine();
			author.setFirstName(firstName);
			scanner.nextLine();
			author.setFirstName(firstName);
			System.out.println("Enter the middle name");
			String middleName=scanner.nextLine();
			author.setMiddleName(middleName);
			System.out.println("Enter the last name");
			String lastName=scanner.nextLine();
			author.setLastName(lastName);
			System.out.println("Enter the phone number");
			String phoneNo =scanner.nextLine();
			author.setPhoneNo(phoneNo);
			authorService.addAuthor(author);
			break;
		case 2:
			System.out.println("Enter the authorId to delete");
			int authorId=scanner.nextInt();
			Author author1=authorService.findAuthor(authorId);
			if(author1!=null)
			{
				System.out.println("Author deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
			break;
		case 3:
			System.out.println("Enter authorId to update");
			int id=scanner.nextInt();
			Author temp=authorService.findAuthor(id);
			if(temp!=null)
			{
				Author tempAuthor=new Author();
				tempAuthor.setAuthorId(temp.getAuthorId());
				System.out.println("Enter the first name to update");
				String firstname=scanner.nextLine();
				scanner.nextLine();
				tempAuthor.setFirstName(firstname);
				System.out.println("Enter the middle name to update");
				String middlename=scanner.nextLine();
				tempAuthor.setMiddleName(middlename);
				System.out.println("Enter the last name to update");
				String lastname=scanner.nextLine();
				tempAuthor.setLastName(lastname);
				System.out.println("Enter the phone no");
				String phoneno=scanner.nextLine();
				tempAuthor.setPhoneNo(phoneno);
				if(authorService.updateAuthor(tempAuthor)!=null)
				{
					System.out.println("updated");
				}
				else {
					System.out.println("not updated");
				}}
				else
				{
					System.out.println("Id not found");
				}
		case 4:
				System.err.println("Thank u");
				
			}
			}
			catch(InputMismatchException e) {
		     	   scanner.nextLine();
		 		   System.err.println("Enter the valid choice"); 
		 		   
		 	   }
			catch(Exception e)
	    	{
	    		System.err.println(e.getMessage());
	    	}
		}
			
		}
		
	}

