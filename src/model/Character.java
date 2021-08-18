package model;

import java.io.Serializable;

public class Character implements Serializable{

	private int id;
	private String name;
	private int str;
	private int hp;



	public Character() {}
//	public Character(String name,String job) {
//		this.name =name;
//		this.job =job;

//	}

	public Character(int id,String name,int hp,int str) {
		this.id =id;
		this.name =name;
		this.hp =hp;
		this.str =str;
	}

	public Character(String name,int hp,int str) {
		this.name =name;
		this.hp =hp;
		this.str =str;
	}
	public int getid() {return id;}
	public String getName() {return name;}
	public int getHp() {return hp;}
	public int getStr() {return str;}



}
