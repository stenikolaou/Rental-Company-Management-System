package com.ps.models;

import java.sql.Date;

public interface RentalDuration {
	
	public static long daysBetween (Date one, Date two) {
		long difference = (one.getTime()-two.getTime())/86400000;
		return Math.abs(difference);
	}
	
	Date one = Rental.getRentalPickupDate();
	Date two = Rental.getRentalReturnDate();
		
}
