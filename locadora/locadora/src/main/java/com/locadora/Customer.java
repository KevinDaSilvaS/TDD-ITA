package com.locadora;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector _rentals = new Vector();
	private double totalAmount = 0;
	private int frequentRenterPoints = 0;

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental rental) {
		_rentals.addElement(rental);
		frequentRenterPoints += rental.getFrequentRenterPoints();
		totalAmount += rental.getAmount();
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		Enumeration rentals = _rentals.elements();

		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();

			result += "\t" + rental.getMovie().getTitle() + 
			"\t" + rental.getAmount() + "\n";
		}

		result += "Amount owed is " + getTotalAmount() + "\n";
		result += "You earned " + getTotalRenterPoints() 
		+ " frequent renter points";

		return result;
	}

	public double getTotalAmount(){
		return this.totalAmount;
	}

	public int getTotalRenterPoints(){
		return this.frequentRenterPoints;
	}
}