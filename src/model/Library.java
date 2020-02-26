package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import main.Start;
import model.Book;

public class Library {

	public int id;
	int numberOfBooks;
	public int daysToSignUp;
	int booksPerDay;
	private HashMap<Integer,Book> books = new HashMap<Integer,Book>();
	private ArrayList<Book> booksUsed = new ArrayList<Book>();
	
	public Library(int id,String details) {
		this.id = id;
		String[] deets = details.split(" ");
		numberOfBooks = Integer.parseInt(deets[0]);
		daysToSignUp = Integer.parseInt(deets[1]);
		booksPerDay = Integer.parseInt(deets[2]);
	}
	
	public void loadBooks(String booksString){
		String[] split = booksString.split(" ");
		for(int i = 0 ; i<split.length; i++){
			int bookId = Integer.parseInt(split[i]);
			books.put(bookId, new Book(bookId,Start.valueOfBooks[bookId]));
		}
			
	}
	
	public int getValueForDays(int days){
		days =- daysToSignUp;
		int value = 0;
		 LinkedList<Book> values = (LinkedList<Book>) books.values();
		 Collections.sort(values, Collections.reverseOrder());
		 Book tempBook;
		while(days > 0 || values.size() > 0){
			for(int i=0;i<booksPerDay;i++)
			{
				tempBook = values.pop();
				value += tempBook.getValue();
				booksUsed.add(tempBook); 
			}
			days--;
		}
		
		return value;       
	}
	
	public void selectLibrary(){
		for(Book b : booksUsed)
		Start.valueOfBooks[b.getId()] = 0;
	}

}
