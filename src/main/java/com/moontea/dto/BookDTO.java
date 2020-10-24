package com.moontea.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.moontea.entity.Book;

public class BookDTO {

	@NotBlank
	@Length(max = 20)
	private String isbn;

	@NotBlank
	private String author;

	@NotBlank
	private String bookName;

	@NotBlank
	private String publish;

	public BookDTO() {
		super();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	@Override
	public String toString() {
		return "BookDTO [isbn=" + isbn + ", author=" + author + ", bookName=" + bookName + ", publish=" + publish + "]";
	}

}
