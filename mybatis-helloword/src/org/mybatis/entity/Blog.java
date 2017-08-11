package org.mybatis.entity;

public class Blog {

	private int id;
	private String title;
	private String author;
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
}
