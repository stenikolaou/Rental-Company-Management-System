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
import com.ps.models.CityDAO;

/***Path: http://localhost:8080/Rental/cities***/
@Path("/cities")
public class CityService {
	
	/***Service to get the list of all cities
	Path: http://localhost:8080/RentalCompany/cities/citylist***/
	@GET
	@Path("/citylist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCities() {
		CityDAO dao = new CityDAO();
		String response;
		List<City> cities = dao.getCities();
		if (cities.size()==0)
			response=constructJSON("Search", false, "No cities found");
		else
			response = constructJSON(cities); 
		return response;
	}
	
	/***Service to perform Create
	Path: http://localhost:8080/Rental/cities/create***/
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addCity(@QueryParam("cityId") String cityId, @QueryParam("cityName") String cityName){
		if (isNotNull(cityId)&&isNotNull(cityName)) {
			CityDAO dao=new CityDAO();
			dao.addCity(new City(cityId, cityName));
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Read 
	Path: http://localhost:8080/Rental/cities/read***/
	@GET
	@Path("/read") 
	@Produces(MediaType.APPLICATION_JSON) 

	public String getCity(@QueryParam("cityName") String cityName){

		CityDAO dao=new CityDAO();
		String response;
		List<City> registeredCity=dao.getCityDetails(cityName);
		if (registeredCity.size()==0)
			response=constructJSON("Search", false, "This city is not served by our company");
		else
			response = constructJSON(registeredCity);
		return response;        
	}

	public String constructJSON(List<City> cities) {
		JSONObject obj = new JSONObject();
		String response="";
		try {
			@SuppressWarnings("rawtypes")
			Iterator itr = cities.iterator();
			while(itr.hasNext()){
				Object[] city = (Object[]) itr.next();
				obj.put("City Id", String.valueOf(city[0]));
				obj.put("City Name", String.valueOf(city[1]));
				response+=obj.toString();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return response;
	}

	/***Service to perform Update
	Path: http://localhost:8080/Rental/cities/update***/
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateCity(@QueryParam("cityId") String cityId, @QueryParam("cityName") String cityName){
		if (isNotNull(cityId)&&isNotNull(cityName)) {
			CityDAO dao=new CityDAO();
			@SuppressWarnings("unused")
			int count = dao.updateCity(cityId, cityName);
		}
		return Response.ok().build().toString();
	}

	/***Service to perform Delete
	Path: http://localhost:8080/Rental/cities/delete***/

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCity(@QueryParam("cityId") String cityId){
		CityDAO dao = new CityDAO();
		int count = dao.deleteCity(cityId);
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
