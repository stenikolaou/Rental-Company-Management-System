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

import com.ps.models.Car;
import com.ps.models.Store;
import com.ps.models.TwoWheeled;
import com.ps.models.Vehicle;
import com.ps.models.VehicleDAO;

/***Path: http://localhost:8080/Rental/vehicles***/
@Path("/vehicles")
public class VehicleService {
	
	/***Service to get the list of all vehicles
	Path: http://localhost:8080/Rental/vehicles/vehiclelist***/
	@GET
	@Path("/vehiclelist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVehicles() {
		VehicleDAO dao = new VehicleDAO();
		String response;
		List<Vehicle> vehicles = dao.getVehicles();
		if (vehicles.size()==0)
			response=constructJSON("Search", false, "No vehicles found");
		else
			response = constructJSON(vehicles); 
		return response;
	}
	
	/***Service to perform Create a car at store ATH01
	Path: http://localhost:8080/Rental/vehicles/cars/createATH01***/
	@POST
	@Path("/cars/createATH01")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addCar1(@QueryParam("vehicleLicenceNo") String vehicleLicenceNo, @QueryParam("vehicleModel") String vehicleModel, @QueryParam("vehicleFuel") String vehicleFuel, @QueryParam("vehicleCapacity") String vehicleCapacity, @QueryParam("vehicleRentalCost") int vehicleRentalCost, @QueryParam("vehicleType") String vehicleType, @QueryParam("vehicleSeatNo") int vehicleSeatNo, @QueryParam("vehicleDoorNumber") int vehicleDoorNumber){
		if (isNotNull(vehicleLicenceNo)&&isNotNull(vehicleModel)&&isNotNull(vehicleFuel)&&isNotNull(vehicleCapacity)&&isNotNull(vehicleType)) {
			VehicleDAO dao=new VehicleDAO();
			Car car1=new Car(vehicleLicenceNo, vehicleModel, vehicleFuel, vehicleCapacity, vehicleRentalCost, vehicleType, vehicleDoorNumber, vehicleDoorNumber);
			Store store1=new Store("ATH01","Athens_Airport");
			car1.setStore(store1);
			dao.addCar(car1);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Create a car at store SKG01
	Path: http://localhost:8080/Rental/vehicles/cars/createSKG01***/
	@POST
	@Path("/cars/createSKG01")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addCar2(@QueryParam("vehicleLicenceNo") String vehicleLicenceNo, @QueryParam("vehicleModel") String vehicleModel, @QueryParam("vehicleFuel") String vehicleFuel, @QueryParam("vehicleCapacity") String vehicleCapacity, @QueryParam("vehicleRentalCost") int vehicleRentalCost, @QueryParam("vehicleType") String vehicleType, @QueryParam("vehicleSeatNo") int vehicleSeatNo, @QueryParam("vehicleDoorNumber") int vehicleDoorNumber){
		if (isNotNull(vehicleLicenceNo)&&isNotNull(vehicleModel)&&isNotNull(vehicleFuel)&&isNotNull(vehicleCapacity)) {
			VehicleDAO dao=new VehicleDAO();
			Car car2=new Car(vehicleLicenceNo, vehicleModel, vehicleFuel, vehicleCapacity, vehicleRentalCost, vehicleType, vehicleDoorNumber, vehicleDoorNumber);
			Store store2=new Store("SKG01","Thessaloniki_Airport");
			car2.setStore(store2);
			dao.addCar(car2);
		}
		return Response.ok().build().toString();
	}
		
	/***Service to perform Create a twowheeled at store ATH01
	Path: http://localhost:8080/Rental/vehicles/twowheeled/createATH01***/
	@POST
	@Path("/twowheeled/createATH01")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addTwoWheeled1(@QueryParam("vehicleLicenceNo") String vehicleLicenceNo, @QueryParam("vehicleModel") String vehicleModel, @QueryParam("vehicleFuel") String vehicleFuel, @QueryParam("vehicleCapacity") String vehicleCapacity, @QueryParam("vehicleRentalCost") int vehicleRentalCost, @QueryParam("vehicleType") String vehicleType, @QueryParam("vehicleSeatHeight") int vehicleSeatHeight, @QueryParam("vehicleLuggageSupport") String vehicleLuggageSupport){
		if (isNotNull(vehicleLicenceNo)&&isNotNull(vehicleModel)&&isNotNull(vehicleFuel)&&isNotNull(vehicleCapacity)&&isNotNull(vehicleLuggageSupport)) {
			VehicleDAO dao=new VehicleDAO();
			TwoWheeled twoWheeled1=new TwoWheeled(vehicleLicenceNo, vehicleModel, vehicleFuel, vehicleCapacity, vehicleRentalCost, vehicleType, vehicleSeatHeight, vehicleLuggageSupport);
			Store store1=new Store("ATH01","Athens_Airport");
			twoWheeled1.setStore(store1);
			dao.addTwoWheeled(twoWheeled1);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Create a twowheeled at store SKG01
	Path: http://localhost:8080/Rental/vehicles/twowheeled/createSKG01***/
	@POST
	@Path("/twowheeled/createSKG01")
	@Produces(MediaType.APPLICATION_JSON) 

	public String addTwoWheeled2(@QueryParam("vehicleLicenceNo") String vehicleLicenceNo, @QueryParam("vehicleModel") String vehicleModel, @QueryParam("vehicleFuel") String vehicleFuel, @QueryParam("vehicleCapacity") String vehicleCapacity, @QueryParam("vehicleRentalCost") int vehicleRentalCost, @QueryParam("vehicleType") String vehicleType,  @QueryParam("vehicleSeatHeight") int vehicleSeatHeight, @QueryParam("vehicleLuggageSupport") String vehicleLuggageSupport){
		if (isNotNull(vehicleLicenceNo)&&isNotNull(vehicleModel)&&isNotNull(vehicleFuel)&&isNotNull(vehicleCapacity)&&isNotNull(vehicleLuggageSupport)) {
			VehicleDAO dao=new VehicleDAO();
			TwoWheeled twoWheeled2=new TwoWheeled(vehicleLicenceNo, vehicleModel, vehicleFuel, vehicleCapacity, vehicleRentalCost, vehicleType, vehicleSeatHeight, vehicleLuggageSupport);
			Store store2=new Store("SKG01","Thessaloniki_Airport");
			twoWheeled2.setStore(store2);
			dao.addTwoWheeled(twoWheeled2);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Read a vehicle 
	Path: http://localhost:8080/Rental/vehicles/read***/
	@GET
	@Path("/read") 
	@Produces(MediaType.APPLICATION_JSON) 

	public String getVehicle(@QueryParam("vehicleModel") String vehicleModel){

		VehicleDAO dao=new VehicleDAO();
		String response;
		List<Vehicle> registeredVehicle=dao.getVehicleDetails(vehicleModel);
		if (registeredVehicle.size()==0)
			response=constructJSON("Search", false, "There is not such a vehicle in our database");
		else
			response = constructJSON(registeredVehicle);
		return response;        
	}

	public String constructJSON(List<Vehicle> vehicles) {
		JSONObject obj = new JSONObject();
		String response="";
		try {
			@SuppressWarnings("rawtypes")
			Iterator itr = vehicles.iterator();
			while(itr.hasNext()){
				Object[] vehicle = (Object[]) itr.next();
				obj.put("Vehicle Licence No", String.valueOf(vehicle[0]));
				obj.put("Store Id", String.valueOf(vehicle[1]));
				obj.put("Vehicle Model", String.valueOf(vehicle[2]));
				obj.put("Vehicle Fuel", String.valueOf(vehicle[3]));
				obj.put("Vehicle Capacity", String.valueOf(vehicle[4]));
				obj.put("Vehicle Rental Cost", String.valueOf(vehicle[5]));
				obj.put("Veicle Seat Height", String.valueOf(vehicle[6]));
				obj.put("Vehicle Luggage Support", String.valueOf(vehicle[7]));
				obj.put("Vehicle Seat No", String.valueOf(vehicle[8]));
				obj.put("Vehicle Door Number", String.valueOf(vehicle[9]));	
				obj.put("Vehicle Type", String.valueOf(vehicle[10]));
				response+=obj.toString();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return response;
	}
	
	/***Service to perform Update a car
	Path: http://localhost:8080/Rental/vehicles/cars/update***/
	@PUT
	@Path("/cars/update")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateCar(@QueryParam("vehicleLicenceNo") String vehicleLicenceNo, @QueryParam("vehicleModel") String vehicleModel, @QueryParam("vehicleFuel") String vehicleFuel, @QueryParam("vehicleCapacity") String vehicleCapacity, @QueryParam("vehicleRentalCost") int vehicleRentalCost, @QueryParam("vehicleSeatNo") int vehicleSeatNo, @QueryParam("vehicleDoorNumber") int vehicleDoorNumber){
		if (isNotNull(vehicleLicenceNo)&&isNotNull(vehicleModel)&&isNotNull(vehicleFuel)&&isNotNull(vehicleCapacity)) {
			VehicleDAO dao=new VehicleDAO();
			@SuppressWarnings("unused")
			int count = dao.updateCar(vehicleLicenceNo,vehicleModel,vehicleFuel,vehicleCapacity,vehicleRentalCost,vehicleSeatNo,vehicleDoorNumber);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Update a twowheeled
	Path: http://localhost:8080/Rental/vehicles/twowheeled/update***/
	@PUT
	@Path("/twowheeled/update")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateTwoWheeled(@QueryParam("vehicleLicenceNo") String vehicleLicenceNo, @QueryParam("vehicleModel") String vehicleModel, @QueryParam("vehicleFuel") String vehicleFuel, @QueryParam("vehicleCapacity") String vehicleCapacity, @QueryParam("vehicleRentalCost") int vehicleRentalCost, @QueryParam("vehicleSeatHeight") int vehicleSeatHeight, @QueryParam("vehicleLuggageSupport") String vehicleLuggageSupport){
		if (isNotNull(vehicleLicenceNo)&&isNotNull(vehicleModel)&&isNotNull(vehicleFuel)&&isNotNull(vehicleCapacity)&&isNotNull(vehicleLuggageSupport)) {
			VehicleDAO dao=new VehicleDAO();
			@SuppressWarnings("unused")
			int count = dao.updateTwoWheeled(vehicleLicenceNo,vehicleModel,vehicleFuel,vehicleCapacity,vehicleRentalCost,vehicleSeatHeight,vehicleLuggageSupport);
		}
		return Response.ok().build().toString();
	}
	
	/***Service to perform Delete
	Path: http://localhost:8080/Rental/vehicles/delete***/

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVehicle(@QueryParam("vehicleLicenceNo") String vehicleLicenceNo){
		VehicleDAO dao = new VehicleDAO();
		int count = dao.deleteVehicle(vehicleLicenceNo);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
	

	/***Method isNotNull String***/
	
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
