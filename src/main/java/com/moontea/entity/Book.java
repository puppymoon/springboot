package com.moontea.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BOOK database table.
 * 
 */
@Entity
@Table(name="book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ISBN")
	private String isbn;

	@Column(name="AUTHOR")
	private String author;

	@Column(name="BOOK_NAME")
	private String bookName;

	@Column(name="Publish")
	private String publish;

	public Book() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublish() {
		return this.publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

}