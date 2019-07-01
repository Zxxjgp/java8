package com.example.demo.java8.chap5;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public  class Trader{
	
	private String name;
	private String city;

	private int points;
	private int qu;


	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}

	public String getName(){
		return this.name;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String newCity){
		this.city = newCity;
	}

	@Override
	public String toString(){
		return "Trader:"+this.name + " in " + this.city;
	}
}