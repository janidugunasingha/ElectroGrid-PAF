package com.emeter.Ctrl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

import com.emeter.Model.Meter;

@Path("/Meter")

public class MeterServices {

	Meter meterObj = new Meter();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readMeter() {
		return meterObj.readMeter();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomer(
			@FormParam("account_no") String account_no,
			@FormParam("name") String name,
			@FormParam("address") String address,
			@FormParam("units") String units,
			@FormParam("date") String date) 
	{
		String output = meterObj.insertMeter(account_no, name, address, units,date);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateMeter(String meterData) {
		
		// Convert the input string to a JSON object
		JsonObject meterObject = new JsonParser().parse(meterData).getAsJsonObject();
		
		// Read the values from the JSON object
		String id = meterObject.get("id").getAsString();
		String account_no = meterObject.get("account_no").getAsString();
		String name = meterObject.get("name").getAsString();
		String address = meterObject.get("address").getAsString();
		String units = meterObject.get("units").getAsString();
		String date = meterObject.get("date").getAsString();
		String output = meterObj.updateMeter(id, account_no, name, address, units, date);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String meterData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(meterData, "", Parser.xmlParser());

		// Read the value from the element <CustomerID>
		String id = doc.select("id").text();
		String output = meterObj.deleteMeter(id);
		return output;
	}

}