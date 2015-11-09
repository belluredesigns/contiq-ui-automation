package com.contiq.pages;

public enum EProjectType {
	BLOG_POST("Blog Post"), PRESENTATIONS("Presentations"), SELECT_PROJECT_TYPE("Select Project Type");

	String e;
	EProjectType(String s){
		e = s;
	}
	public String toString()
	{
		return e;
	}
}
