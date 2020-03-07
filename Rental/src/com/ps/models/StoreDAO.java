package com.ps.models;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

@SuppressWarnings("deprecation")
public class StoreDAO {
	
	 public List<Store> getStores() {
		 Session session = SessionUtil.getSession();
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("Select * from Store");
		 @SuppressWarnings("unchecked")
		List<Store> stores = query.list();
		 session.close();
		 return stores;
	 }
	 
	public void addStore(Store bean){
       Session session = SessionUtil.getSession();        
       Transaction tx = session.beginTransaction();
       try {
			session.save(bean);
			tx.commit();
		} catch (PersistenceException e) {System.out.println("Persistence Exception");} 
   	
       session.close(); 
	}
	
	 public List<Store> getStoreDetails(String storeName){
	        Session session = SessionUtil.getSession();    
	        @SuppressWarnings("rawtypes")
			NativeQuery query = session.createNativeQuery("Select * from Store where STORE_NAME=?1");
	        query.setParameter(1, storeName);
	        @SuppressWarnings("unchecked")
			List<Store> stores =  query.list();
	        session.close();
	        return stores;
	    }
	 
	 public int updateStore (String storeId,String storeName) {
		 Session session = SessionUtil.getSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "update Store set STORE_NAME=?1 where STORE_ID=?2";
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery(hql);
		 query.setParameter(1, storeName);
		 query.setParameter(2, storeId);
		 int rowCount = query.executeUpdate();
		 System.out.println("rows affected: "+rowCount);
		 tx.commit();
		 session.close();
		 return rowCount;
	 }
	 
	 public int deleteStore(String storeId) {
	        Session session = SessionUtil.getSession();
	        Transaction tx = session.beginTransaction();
	        String hql = "delete from Store where STORE_ID = :storeId";
	        @SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
	        query.setString("storeId",storeId);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        tx.commit();
	        session.close();
	        return rowCount;
	    }
	
}
