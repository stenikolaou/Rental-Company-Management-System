package com.ps.models;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

@SuppressWarnings("deprecation")
public class ClientDAO {
	
	public List<Client> getClients() {
		 Session session = SessionUtil.getSession();
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("Select * from Client");
		 @SuppressWarnings("unchecked")
		List<Client> clients = query.list();
		 session.close();
		 return clients;
	 }
	 
	public void addClient(Client bean){
       Session session = SessionUtil.getSession();        
       Transaction tx = session.beginTransaction();
       try {
			session.save(bean);
			tx.commit();
		} catch (PersistenceException e) {System.out.println("Persistence Exception");} 
   	
       session.close(); 
	}
	
	public List<Client> getClientDetails(String clientSurname){
        Session session = SessionUtil.getSession();    
        @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery("Select * from Client where CLIENT_SURNAME=?1");
        query.setParameter(1, clientSurname);
        @SuppressWarnings("unchecked")
		List<Client> clients =  query.list();
        session.close();
        return clients;
    }
	
	public int updateClient (String clientId, String clientName, String clientSurname, String clientDrivingLicense,
			String clientAdress, String clientEmail, String clientTelephoneNo) {
		 Session session = SessionUtil.getSession();
		 Transaction tx = session.beginTransaction();
		 String hql = "update Client set CLIENT_NAME=?1, CLIENT_SURNAME=?2, CLIENT_DRIVING_LICENSE=?3, CLIENT_ADDRESS=?4, CLIENT_EMAIL=?5, CLIENT_TELEPHONE_NO=?6 where CLIENT_ID=?7";
		 @SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery(hql);
		 query.setParameter(1, clientName);
		 query.setParameter(2, clientSurname);
		 query.setParameter(3, clientDrivingLicense);
		 query.setParameter(4, clientAdress);
		 query.setParameter(5, clientEmail);
		 query.setParameter(6, clientTelephoneNo);
		 query.setParameter(7, clientId);
		 int rowCount = query.executeUpdate();
		 System.out.println("rows affected: "+rowCount);
		 tx.commit();
		 session.close();
		 return rowCount;
	 }
	 
	 public int deleteClient(String clientId) {
	        Session session = SessionUtil.getSession();
	        Transaction tx = session.beginTransaction();
	        String hql = "delete from Client where CLIENT_ID = :clientId";
	        @SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
	        query.setString("clientId",clientId);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        tx.commit();
	        session.close();
	        return rowCount;
	    }

}
