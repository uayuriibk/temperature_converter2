package com.yuriyb.jersey.temperatureconverter2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/c2fservice")
public class C2FService {
	
	@GET
	@Produces("application/xml")
	public String convertC2F() {

		Double celsiusValue = 30.0;
		Double fahrenheitValue = ((celsiusValue * 9) / 5) + 32;

		String result = "@Produces(\"application/xml\") Result: \n\nC -> F Converting Result: \n\n"
				+ fahrenheitValue;
		
		return "<c2fservice>" + "<celsiusValue>" + celsiusValue + "</celsiusValue>"+ "<c2fresult>" 
				+ result + "</c2fresult>" + "</c2fservice>";
	}

	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertC2FfromInput(@PathParam("c") Double c) {
		
		Double celsiusValue = c;
		Double fahrenheitValue = ((celsiusValue * 9) / 5) + 32;

		String result = "@Produces(\"application/xml\") Result: \n\nC -> F Converting Result: \n\n"
				+ fahrenheitValue;
		
		return "<c2fservice>" + "<celsiusValue>" + celsiusValue + "</celsiusValue>"
				+ "<c2foutput>" + result + "</c2foutput>" + "</c2fservice>";
	}
}