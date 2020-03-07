package com.ps.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

@SuppressWarnings("deprecation")
public class RentalDAO {
	
	 public List<Rental> getRentals() {
		 Session session = SessionUtil.getSession();
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("Select * from rental");
		 @SuppressWarnings("unchecked")
		List<Rental> rentals = query.list();
		 session.close();
		 return rentals;
	 }
	 
	 public void addRental(Rental bean){
	       Session session = SessionUtil.getSession();        
	       Transaction tx = session.beginTransaction();
	       try {
				session.save(bean);
				tx.commit();
			} catch (PersistenceException e) {System.out.println("Persistence Exception");} 
	   	
	       session.close(); 
		}
	 
	 public List<Rental> getRentalDetails(String rentalId){
	        Session session = SessionUtil.getSession();    
	        @SuppressWarnings("rawtypes")
			NativeQuery query = session.createNativeQuery("Select * from rental where RENTAL_ID=?1");
	        query.setParameter(1, rentalId);
	        @SuppressWarnings("unchecked")
			List<Rental> rentals =  query.list();
	        session.close();
	        return rentals;
	    }
	 
	 public int updateRental (String rentalId, String rentalPickupLocation, Date rentalPickupDate,
				String rentalReturnLocation, Date rentalReturnDate, int rentalTotalCost) {
		 Session session = SessionUtil.getSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "update rental set RENTAL_PICKUP_LOCATION=?1, RENTAL_PICKUP_DATE=?2, RENTAL_RETURN_LOCATION=?3, RENTAL_RETURN_DATE=?4, RENTAL_TOTAL_COST=?5 where RENTAL_ID=?6";
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery(hql);
		 query.setParameter(1, rentalPickupLocation);
		 query.setParameter(2, rentalPickupDate);
		 query.setParameter(3, rentalReturnLocation);
		 query.setParameter(4, rentalReturnDate);
		 query.setParameter(5, rentalTotalCost);
		 query.setParameter(6, rentalId);
		 int rowCount = query.executeUpdate();
		 System.out.println("rows affected: "+rowCount);
		 tx.commit();
		 session.close();
		 return rowCount;
	 }
	 
	 public int deleteRental(String rentalId) {
	        Session session = SessionUtil.getSession();
	        Transaction tx = session.beginTransaction();
	        String hql = "delete from Rental where RENTAL_ID = :rentalId";
	        @SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
	        query.setString("rentalId",rentalId);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        tx.commit();
	        session.close();
	        return rowCount;
	    }

}
