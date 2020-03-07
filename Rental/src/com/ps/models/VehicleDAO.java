package com.ps.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

@SuppressWarnings("deprecation")
public class VehicleDAO {
	
	public List<Vehicle> getVehicles() {
		 Session session = SessionUtil.getSession();
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("Select * from Vehicle");
		 @SuppressWarnings("unchecked")
		List<Vehicle> vehicles = query.list();
		 session.close();
		 return vehicles;
	 }
	
	public void addCar(Car bean){
	       Session session = SessionUtil.getSession();        
	       Transaction tx = session.beginTransaction();
	       try {
				session.save(bean);
				tx.commit();
			} catch (PersistenceException e) {System.out.println("Persistence Exception");} 
	   	
	       session.close(); 
		}
	
	public void addTwoWheeled(TwoWheeled bean){
	       Session session = SessionUtil.getSession();        
	       Transaction tx = session.beginTransaction();
	       try {
				session.save(bean);
				tx.commit();
			} catch (PersistenceException e) {System.out.println("Persistence Exception");} 
	   	
	       session.close(); 
		}
	
	public List<Vehicle> getVehicleDetails (String vehicleModel){
        Session session = SessionUtil.getSession();    
        @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("Select * from Vehicle where VEHICLE_MODEL=?1");
        query.setParameter(1, vehicleModel);
        @SuppressWarnings("unchecked")
		List<Vehicle> vehicles =  query.list();
        session.close();
        return vehicles;
    }
	
	public int updateCar (String vehicleLicenceNo, String vehicleModel, String vehicleFuel, String vehicleCapacity,
			int vehicleRentalCost, int vehicleSeatNo, int vehicleDoorNumber) {
		 Session session = SessionUtil.getSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "update Vehicle set VEHICLE_MODEL=?1, VEHICLE_FUEL=?2, VEHICLE_CAPACITY=?3, VEHICLE_RENTAL_COST=?4, VEHICLE_SEAT_NO=?5, VEHICLE_DOOR_NUMBER=?6 where VEHICLE_LICENCE_NO=?7";
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery(hql);
		 query.setParameter(1, vehicleModel);
		 query.setParameter(2, vehicleFuel);
		 query.setParameter(3, vehicleCapacity);
		 query.setParameter(4, vehicleRentalCost);
		 query.setParameter(5, vehicleSeatNo);
		 query.setParameter(6, vehicleDoorNumber);
		 query.setParameter(7, vehicleLicenceNo);
		 int rowCount = query.executeUpdate();
		 System.out.println("rows affected: "+rowCount);
		 tx.commit();
		 session.close();
		 return rowCount;
	 }
	
	public int updateTwoWheeled (String vehicleLicenceNo, String vehicleModel, String vehicleFuel, String vehicleCapacity,
			int vehicleRentalCost, int vehicleSeatHeight, String vehicleLuggageSupport) {
		 Session session = SessionUtil.getSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "update Vehicle set VEHICLE_MODEL=?1, VEHICLE_FUEL=?2, VEHICLE_CAPACITY=?3, VEHICLE_RENTAL_COST=?4, VEHICLE_SEAT_HEIGHT=?6, VEHICLE_LUGGAGE_SUPPORT=?6 where VEHICLE_LICENCE_NO=?7";
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery(hql);
		 query.setParameter(1, vehicleModel);
		 query.setParameter(2, vehicleFuel);
		 query.setParameter(3, vehicleCapacity);
		 query.setParameter(4, vehicleRentalCost);
		 query.setParameter(5, vehicleSeatHeight);
		 query.setParameter(6, vehicleLuggageSupport);
		 query.setParameter(7, vehicleLicenceNo);
		 int rowCount = query.executeUpdate();
		 System.out.println("rows affected: "+rowCount);
		 tx.commit();
		 session.close();
		 return rowCount;
	 }
	
	public int deleteVehicle(String vehicleLicenceNo) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Vehicle where VEHICLE_LICENCE_NO = :vehicleLicenceNo";
        @SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
        query.setString("vehicleLicenceNo",vehicleLicenceNo);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
	
	public List<Vehicle> checkVehicleAvailability(String rentalPickupLocation, Date rentalPickupDate, Date rentalReturnDate) {
		Session session = SessionUtil.getSession();    
		@SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("SELECT vehicle.* FROM vehicle,rental,store,city WHERE rental.VEHICLE_LICENCE_NO="
				+ "vehicle.VEHICLE_LICENCE_NO AND vehicle.STORE_ID=store.STORE_ID and store.CITY_ID=city.CITY_ID AND city.CITY_NAME='"+rentalPickupLocation+"'"
				+ " and rental.RENTAL_PICKUP_DATE <= '"+rentalReturnDate+"' and rental.RENTAL_RETURN_DATE >= '"+rentalPickupDate+"' GROUP BY VEHICLE_LICENCE_NO");
        @SuppressWarnings("unchecked")
		List<Vehicle> availableVehicles = query.list();
        session.close();
        return availableVehicles;
	}
	
	   public List<Vehicle> getCityVehicles(String rentalPickupLocation){
	        Session session = SessionUtil.getSession();    
	        @SuppressWarnings("rawtypes")
			NativeQuery query = session.createNativeQuery("SELECT vehicle.* from vehicle, store, city where"
	        		+ " vehicle.STORE_ID=store.STORE_ID and store.CITY_ID=city.CITY_ID and city.CITY_NAME='"+rentalPickupLocation+"'");
	        @SuppressWarnings("unchecked")
			List<Vehicle> cityVehicles = query.list();
	        session.close();
	        return cityVehicles;
	    }
	
}