package com.ok;

/**
 * Created by luba on 13.11.15.
 */
public class Tweet {
	private String name;
	private  String text;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Tweet(String name, String text) {
		this.name = name;
		this.text = text;
	}

	@Override
	public String toString() {
		return name +"&&" + text;
	}
}
