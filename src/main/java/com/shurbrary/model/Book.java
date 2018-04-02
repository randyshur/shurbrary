package com.shurbrary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String title;
	String summary;
	Date dueDate;
	Long checkedOut;

	public Book() { }

	public Book(Long id, String title, String summary, Date dueDate, Long checkedOut) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.dueDate = dueDate;
		this.checkedOut = checkedOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getCheckedOut() {
		return checkedOut;
	}

}
