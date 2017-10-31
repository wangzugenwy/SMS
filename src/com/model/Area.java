package com.model;

public class Area {
    private int id;
    private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Area(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public Area() {
		super();
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", title=" + title + "]";
	}
    
}
