package com.ps.demo;

import java.sql.Date;
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

import com.ps.models.Rental;
import com.ps.models.RentalDAO;

/***Path: http://localhost:8080/Rental/rentals***/
@Path("/rentals")
public class RentalService {
	
	/***Service to get the list of all rentals
	Path: http://localhost:8080/Rental/rentals/rentalslist***/
	@GET
	@Path("/rentalslist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRentals() {
		RentalDAO dao = new RentalDAO();
		String response;
		List<Rental> rentals = dao.getRentals();
		if (rentals.size()==0)
			response=constructJSON("Search", false, "No rentals found");
		else
			response = constructJSON(rentals); 
		return response;
	}
	
	public String constructJSON(List<Rental> rentals) {
		JSONObject obj = new JSONObject();
		String response="";
		try {
			@SuppressWarnings("rawtypes")
			Iterator itr = rentals.iterator();
			while(itr.hasNext()){
				Object[] rental = (Object[]) itr.next();
				obj.put("Rental Id", String.valueOf(rental[0]));
				obj.put("Vehicle Licence No", String.valueOf(rental[1]));
				obj.put("Client Id", String.valueOf(rental[2]));
				obj.put("Rental Pickup Location", String.valueOf(rental[3]));
				obj.put("Rental Pickup Date", String.valueOf(rental[4]));
				obj.put("Rental Return Location", String.valueOf(rental[5]));
				obj.put("Rental Return Date", String.valueOf(rental[6]));
				obj.put("Rental Total Cost", String.valueOf(rental[7]));
				response+=obj.toString();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return response;
	}
	
	/***Service to perform Create
	Path: http://localhost:8080/Rental/rentals/create***/
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addRental (@QueryParam("rentalId") String rentalId, @QueryParam("rentalPickupLocation") String rentalPickupLocation, 
			@QueryParam("rentalPickupDate") Date rentalPickupDate, @QueryParam("rentalReturnLocation") String rentalReturnLocation, 
			@QueryParam("rentalReturnDate") Date rentalReturnDate, @QueryParam("rentalTotalCost") int rentalTotalCost) {
		if (isNotNull(rentalId)&&isNotNull(rentalPickupLocation)&&isNotNull(rentalReturnLocation)) {
			RentalDAO dao=new RentalDAO();
			dao.addRental(new Rental(rentalId, rentalPickupLocation, rentalPickupDate, rentalReturnLocation, rentalReturnDate, rentalTotalCost));
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Update
	Path: http://localhost:8080/RentalCompany/rentals/update***/
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateCity (@QueryParam("rentalId") String rentalId, @QueryParam("rentalPickupLocation") String rentalPickupLocation, 
			@QueryParam("rentalPickupDate") Date rentalPickupDate, @QueryParam("rentalReturnLocation") String rentalReturnLocation, 
			@QueryParam("rentalReturnDate") Date rentalReturnDate, @QueryParam("rentalTotalCost") int rentalTotalCost) {
		if (isNotNull(rentalId)&&isNotNull(rentalPickupLocation)&&isNotNull(rentalReturnLocation)) {
			RentalDAO dao=new RentalDAO();
			@SuppressWarnings("unused")
			int count = dao.updateRental(rentalId, rentalPickupLocation, rentalPickupDate, rentalReturnLocation, rentalReturnDate, rentalTotalCost);
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Delete
	Path: http://localhost:8080/Rental/rentals/delete***/

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRental(@QueryParam("rentalId") String rentalId){
		RentalDAO dao = new RentalDAO();
		int count = dao.deleteRental(rentalId);
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
