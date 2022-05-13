package model;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

public class Mutter implements Serializable{
	
	private int id; //id
	private String userName; //ユーザー名
	private String text; //つぶやき内容
	private Timestamp date;// 日時
	
	public Mutter() {}
	
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	
	public Mutter(int id, String userName, String text, Timestamp date) {
		this.id = id;
		this.userName = userName;
		this.text = text;
		this.date = date;
		
	}

	public int getId() {return id;}
	
	public String getUserName() {return userName;}
	
	public String getText() {return text;}
	
	public Timestamp getDate() {return date;}
		
/*
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String formatedDate = sdf.format(date);
		return formatedDate;
	}
*/
	
}
