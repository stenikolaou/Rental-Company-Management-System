package com.ps.demo;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ps.models.City;
import com.ps.models.Store;
import com.ps.models.StoreDAO;

/***Path: http://localhost:8080/Rental/stores***/
@Path("/stores")
public class StoreService {
	
	/***Service to get the list of all stores
	Path: http://localhost:8080/Rental/stores/storelist***/
	@GET
	@Path("/storelist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStores() {
		StoreDAO dao = new StoreDAO();
		String response;
		List<Store> stores = dao.getStores();
		if (stores.size()==0)
			response=constructJSON("Search", false, "No stores found");
		else
			response = constructJSON(stores); 
		return response;
	}

	/***Service to perform Create a store in Athens
	Path: http://localhost:8080/RentalCompany/stores/createATH***/
	@POST
	@Path("/createATH")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addStore1(@QueryParam("storeId") String storeId, @QueryParam("storeName") String storeName){
		if (isNotNull(storeId)&&isNotNull(storeName)) {
			StoreDAO dao=new StoreDAO();
			Store store1=new Store (storeId, storeName);
			City city1=new City("ATH","Athens");
			store1.setCity(city1);
			dao.addStore(store1);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Create a store in Thessaloniki
	Path: http://localhost:8080/Rental/stores/createSKG***/
	@POST
	@Path("/createSKG")
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String addStore2(@QueryParam("storeId") String storeId, @QueryParam("storeName") String storeName){
		if (isNotNull(storeId)&&isNotNull(storeName)) {
			StoreDAO dao=new StoreDAO();
			Store store2=new Store (storeId, storeName);
			City city2=new City("SKG","Thessaloniki");
			store2.setCity(city2);
			dao.addStore(store2);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Create a store in Heraklion
	Path: http://localhost:8080/Rental/stores/createHER***/
	@POST
	@Path("/createHER")
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String addStore3(@QueryParam("storeId") String storeId, @QueryParam("storeName") String storeName){
		if (isNotNull(storeId)&&isNotNull(storeName)) {
			StoreDAO dao=new StoreDAO();
			Store store3=new Store (storeId, storeName);
			City city3=new City("HER","Heraklion");
			store3.setCity(city3);
			dao.addStore(store3);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Create a store in Rhodes
	Path: http://localhost:8080/Rental/stores/createRHO***/
	@POST
	@Path("/createRHO")
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String addStore4(@QueryParam("storeId") String storeId, @QueryParam("storeName") String storeName){
		if (isNotNull(storeId)&&isNotNull(storeName)) {
			StoreDAO dao=new StoreDAO();
			Store store4=new Store (storeId, storeName);
			City city4=new City("RHO","Rhodes");
			store4.setCity(city4);
			dao.addStore(store4);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Create a store in Corfu
	Path: http://localhost:8080/Rental/stores/createCFU***/
	@POST
	@Path("/createCFU")
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String addStore5(@QueryParam("storeId") String storeId, @QueryParam("storeName") String storeName){
		if (isNotNull(storeId)&&isNotNull(storeName)) {
			StoreDAO dao=new StoreDAO();
			Store store5=new Store (storeId, storeName);
			City city5=new City("CFU","Corfu");
			store5.setCity(city5);
			dao.addStore(store5);
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Read 
	Path: http://localhost:8080/Rental/stores/read***/
	@GET
	@Path("/read") 
	@Produces(MediaType.APPLICATION_JSON) 

	public String getStore(@QueryParam("storeName") String storeName){

		StoreDAO dao=new StoreDAO();
		String response;
		List<Store> registeredStore=dao.getStoreDetails(storeName);
		if (registeredStore.size()==0)
			response=constructJSON("Search", false, "There is not such a store in our network");
		else
			response = constructJSON(registeredStore);
		return response;        
	}

	public String constructJSON(List<Store> stores) {
		JSONObject obj = new JSONObject();
		String response="";
		try {
			@SuppressWarnings("rawtypes")
			Iterator itr = stores.iterator();
			while(itr.hasNext()){
				Object[] store = (Object[]) itr.next();
				obj.put("Store Id", String.valueOf(store[0]));
				obj.put("City Id", String.valueOf(store[1]));
				obj.put("Store Name", String.valueOf(store[2]));
				response+=obj.toString();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return response;
	}

	/***Service to perform Update
	Path: http://localhost:8080/Rental/stores/update***/
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateStore(@QueryParam("storeId") String storeId, @QueryParam("storeName") String storeName){
		if (isNotNull(storeId)&&isNotNull(storeName)) {
			StoreDAO dao=new StoreDAO();
			@SuppressWarnings("unused")
			int count = dao.updateStore(storeId, storeName);
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Delete
	Path: http://localhost:8080/Rental/stores/delete***/

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCity(@QueryParam("storeId") String storeId){
		StoreDAO dao = new StoreDAO();
		int count = dao.deleteStore(storeId);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
	
	/***Method isNotNull***/
	
	public boolean isNotNull(String txt) {
		// System.out.println("Inside isNotNull");
		return txt != null && txt.trim().length() >= 0 ? true : false;
	}

	/***Method constructJSON with error msg***/
	
	public String constructJSON(String tag, boolean status,String err_msg) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", new Boolean(status));
			obj.put("error_msg", err_msg);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}

}
