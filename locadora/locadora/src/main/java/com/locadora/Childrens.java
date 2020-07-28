package com.locadora;

public class Childrens extends Movie{

	public Childrens(String title) {
		super(title);
    }
    
    public double getAmount(int daysRented) {
		double thisAmount = 1.5;
		if(daysRented > 3){
			thisAmount += (daysRented - 3) * 1.5;
		}
		return thisAmount;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}