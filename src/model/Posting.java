package model;

import java.io.Serializable;

public class Posting implements Serializable{
	private static final long serialVersionUID = -6036485607356343947L;
	
	private String name;
	private String text;
	private String time;
	private String color;
	private String size;
	private String save;
	
	public Posting(){
		//デフォルトコンストラクタ
	}
	public Posting(String name,String text,String time,String color,String size,String save){
		this.name = name;
		this.text = text;
		this.time = time;
		this.color = color;
		this.size = size;
		this.save = save;
	}
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSave() {
		return save;
	}
	public void setSave(String save) {
		this.save = save;
	}
}
