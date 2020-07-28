package com.locadora;

public abstract class Movie {
	
	public static final int CHILDRENS = 2;

	public static final int REGULAR = 0;

	public static final int NEW_RELEASE = 1;

	private String _title;

	public Movie(String title) {
		_title = title;
	}

	public static Movie createMovie(String title, int priceCode) {
		if (priceCode == REGULAR) {
			return new Regular(title);
		}

		if (priceCode == NEW_RELEASE) {
			return new NewRelease(title);
		}

		if (priceCode == CHILDRENS) {
			return new Childrens(title);
		}
		
		throw new RuntimeException("Movie type doens´t exists.");
	}

	public String getTitle() {
		return _title;
	};

	public abstract double getAmount(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);
	
}