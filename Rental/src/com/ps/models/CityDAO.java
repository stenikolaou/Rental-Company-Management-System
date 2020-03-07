package com.ps.models;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

@SuppressWarnings("deprecation")
public class CityDAO {
	
	 public List<City> getCities() {
		 Session session = SessionUtil.getSession();
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("Select * from City");
		 @SuppressWarnings("unchecked")
		List<City> cities = query.list();
		 session.close();
		 return cities;
	 }
	 
	public void addCity(City bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        try {
			session.save(bean);
			tx.commit();
		} catch (PersistenceException e) {System.out.println("Persistence Exception");} 
    	
        session.close(); 
	}
	
	 public List<City> getCityDetails(String cityName){
	        Session session = SessionUtil.getSession();    
	        @SuppressWarnings("rawtypes")
			NativeQuery query = session.createNativeQuery("Select * from City where CITY_NAME=?1");
	        query.setParameter(1, cityName);
	        @SuppressWarnings("unchecked")
			List<City> cities =  query.list();
	        session.close();
	        return cities;
	    }
	 
	 public int updateCity (String cityId,String cityName) {
		 Session session = SessionUtil.getSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "update City set CITY_NAME=?1 where CITY_ID=?2";
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery(hql);
		 query.setParameter(1, cityName);
		 query.setParameter(2, cityId);
		 int rowCount = query.executeUpdate();
		 System.out.println("rows affected: "+rowCount);
		 tx.commit();
		 session.close();
		 return rowCount;
	 }
	 
	 public int deleteCity(String cityId) {
	        Session session = SessionUtil.getSession();
	        Transaction tx = session.beginTransaction();
	        String hql = "delete from City where CITY_ID = :cityId";
	        @SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
	        query.setString("cityId",cityId);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        tx.commit();
	        session.close();
	        return rowCount;
	    }
	
}
