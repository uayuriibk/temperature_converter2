package com.yuriyb.jersey.temperatureconverter2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/f2cservice")
public class F2CService {
 
	  @GET
	  @Produces("application/json")
	  public Response convertF2C() {
 
		JSONObject jsonObject = new JSONObject();
		Double fahrenheitValue = 80.00;
		Double celsiusValue = (fahrenheitValue - 32)*5/9;
		
		jsonObject.put("F Value", fahrenheitValue); 
		jsonObject.put("C Value", celsiusValue);
 
		String result = "@Produces(\"application/json\") Output: \n\nF -> C Converting Result: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertF2CfromInput(@PathParam("f") float f) {
 
		JSONObject jsonObject = new JSONObject();
		float celsius = (f - 32)*5/9;
		
		jsonObject.put("F Value", f); 
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Result: \n\nF -> C Converting Result: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
}