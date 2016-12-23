package model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 6928751497859093826L;
	
	private String name;
	private String pass;
	private String color = "BLACK";
	private String size = "TALL";
	private String save = "FALSE";
	private String thema = "lime";
	
	public User(){
		//デフォルトコンストラクタ
	}
	public User(String name,String pass,String thema){
		this.name = name;
		this.pass = pass;
		this.thema = thema;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getchecked(){
		String s = "checked=\"checked\"";
		return s;
	}
	public String getThema() {
		return thema;
	}
	public void setThema(String thema) {
		this.thema = thema;
	}
	
}
