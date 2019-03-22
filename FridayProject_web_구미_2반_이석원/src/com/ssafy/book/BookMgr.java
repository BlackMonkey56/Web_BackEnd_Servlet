package com.ssafy.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMgr {
	private List<Book> books;
	
	//싱글톤
	private static BookMgr bookMgr = new BookMgr();
	private BookMgr() {
		books = new ArrayList<Book>();
	}
	public static BookMgr getInstance() {
		return bookMgr;
	}
	
	//--------------------------------------------------------
	
	public void add(Book b) throws SQLException {
		boolean exist = false;
		//중복 검사
		for(Book book : books) {
			if(book.equals(b.getIsbn())) {
				exist = true;
				break;
			}
		}
		
		//중복여부에 따라 도서 등록
		if(!exist) {
			books.add(b);
		}else {
			System.out.println("이미 등록된 도서입니다.");
			throw new SQLException();
		}
	}
	
	public List<Book> search(){
		return books;
	}
	
	public Book searchByIsbn(String isbn) {
		Book searchedBook = null;
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				searchedBook = book;
				break;
			}
		}
		
		return searchedBook;
	}
	
	public void delete(String isbn) throws SQLException {
		boolean isDelete = false;
		
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				books.remove(book);
				isDelete = true;
				System.out.println("도서제거 완료");
				break;
			}
		}
		
		if(!isDelete) {
			throw new SQLException();
		}
	}
	
	public List<Book> searchByTitle(String title) {
		ArrayList<Book> searchedList = new ArrayList<>();
		
		for(Book book : books) {
			if(book.getTitle().contains(title)) {
				searchedList.add(book);
			}
		}
		
		return searchedList;
	}
	
	public List<Book> searchByPublisher(String publisher) {
		ArrayList<Book> searchedList = new ArrayList<>();
		
		for(Book book : books) {
			if(book.getPublisher().contains(publisher)) {
				searchedList.add(book);
			}
		}
		
		return searchedList;
	}
	
	public List<Book> searchByPrice(int price) {
		ArrayList<Book> searchedList = new ArrayList<>();
		
		for(Book book : books) {
			if(book.getPrice() <= price) {
				searchedList.add(book);
			}
		}
		
		return searchedList;
	}
}
