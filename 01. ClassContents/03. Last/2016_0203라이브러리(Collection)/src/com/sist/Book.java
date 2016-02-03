package com.sist;

public class Book {
    private int no;
    private String title;
    private String author;
    private String publisher;
    private String poster;
    private int price;
    public Book()
    {
    	
    }
	public Book(int no, String title, String author, String publisher, String poster, int price) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.poster = poster;
		this.price = price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
   
}
