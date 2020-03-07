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

import com.ps.models.Client;
import com.ps.models.ClientDAO;

/***Path: http://localhost:8080/Rental/clients***/
@Path("/clients")
public class ClientService {
	
	/***Service to get the list of all clients
	Path: http://localhost:8080/RentalCompany/clients/clientlist***/
	@GET
	@Path("/clientlist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getClients() {
		ClientDAO dao = new ClientDAO();
		String response;
		List<Client> clients = dao.getClients();
		if (clients.size()==0)
			response=constructJSON("Search", false, "No clients found");
		else
			response = constructJSON(clients); 
		return response;
	}

	/***Service to perform Create
	Path: http://localhost:8080/Rental/clients/create***/
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addClient(@QueryParam("clientId") String clientId, @QueryParam("clientName") String clientName, @QueryParam("clientSurname") String clientSurname, @QueryParam("clientDrivingLicense") String clientDrivingLicense, @QueryParam("clientAdress") String clientAdress, @QueryParam("clientEmail") String clientEmail, @QueryParam("clientTelephoneNo") String clientTelephoneNo){
		if (isNotNull(clientId)&&isNotNull(clientName)&&isNotNull(clientSurname)&&isNotNull(clientDrivingLicense)&&isNotNull(clientAdress)&&isNotNull(clientEmail)&&isNotNull(clientTelephoneNo)) {
			ClientDAO dao=new ClientDAO();
			dao.addClient(new Client(clientId, clientName, clientSurname, clientDrivingLicense, clientAdress, clientEmail, clientTelephoneNo));
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Read 
	Path: http://localhost:8080/Rental/clients/read***/
	@GET
	@Path("/read") 
	@Produces(MediaType.APPLICATION_JSON) 

	public String getClient(@QueryParam("clientSurname") String clientSurname){

		ClientDAO dao=new ClientDAO();
		String response;
		List<Client> registeredClient=dao.getClientDetails(clientSurname);
		if (registeredClient.size()==0)
			response=constructJSON("Search", false, "This client is not registered in our database");
		else
			response = constructJSON(registeredClient);
		return response;        
	}

	public String constructJSON(List<Client> clients) {
		JSONObject obj = new JSONObject();
		String response="";
		try {
			@SuppressWarnings("rawtypes")
			Iterator itr = clients.iterator();
			while(itr.hasNext()){
				Object[] client = (Object[]) itr.next();
				obj.put("Client Id", String.valueOf(client[0]));
				obj.put("Client Name", String.valueOf(client[1]));
				obj.put("Client Surname", String.valueOf(client[2]));
				obj.put("Client Driving License", String.valueOf(client[3]));
				obj.put("City Adress", String.valueOf(client[4]));
				obj.put("City Email", String.valueOf(client[5]));
				obj.put("City Tel. No", String.valueOf(client[6]));
				response+=obj.toString();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return response;
	}
	
	/***Service to perform Update
	Path: http://localhost:8080/Rental/clients/update***/
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateClient(@QueryParam("clientId") String clientId, @QueryParam("clientName") String clientName, @QueryParam("clientSurname") String clientSurname, @QueryParam("clientDrivingLicense") String clientDrivingLicense, @QueryParam("clientAdress") String clientAdress, @QueryParam("clientEmail") String clientEmail, @QueryParam("clientTelephoneNo") String clientTelephoneNo){
		if (isNotNull(clientId)&&isNotNull(clientName)&&isNotNull(clientSurname)&&isNotNull(clientDrivingLicense)&&isNotNull(clientAdress)&&isNotNull(clientEmail)&&isNotNull(clientTelephoneNo)) {
			ClientDAO dao=new ClientDAO();
			@SuppressWarnings("unused")
			int count = dao.updateClient(clientId, clientName, clientSurname, clientDrivingLicense, clientAdress, clientEmail, clientTelephoneNo);
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Delete
	Path: http://localhost:8080/Rental/clients/delete***/

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClient(@QueryParam("clientId") String clientId){
		ClientDAO dao = new ClientDAO();
		int count = dao.deleteClient(clientId);
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
