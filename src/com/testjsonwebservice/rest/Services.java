package com.testjsonwebservice.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.testjsonwebservice.pss.Database;
import com.testjsonwebservice.pss.Psirt;

@Path ("/getPsirts")
public class Services {
	@GET
	//@Produces("application/json")
	@Produces("text/plain")
	public String GetControls() {
		return getAllControls();
	}

	private String getAllControls()
	{
		ArrayList<Psirt> psirts = Database.getPsirts(); 
		String json; 
		//String json = "here{\"success\":\"true\",\"controls\":[{\"controlID\":\"1\",\"type\":\"TEXTBOX\"},{\"controlID\":\"4\",\"type\":\"CHECKBOX\"}]}";
		json = "{\"psirts\": ["; 
		boolean first = true; 
		for(Psirt p : psirts) {
			if(first == false) {
				json+=",";
			}
			json += "{";
			json += "\"headline\": \"" + p.getHeadline() + "\",";
			json += "\"alertversion\": \"" + p.getAlertVersion() + "\",";
			json += "\"alertid\": \"" + p.getAlertId() + "\",";
			json += "\"firstpublisehd\": \"" + p.getFirstPublished() + "\",";
			json += "\"lastupdated\": \"" + p.getLastUpdated() + "\",";
			json += "\"impact\": \"" + p.getImpact() + "\",";
			json += "\"url\": \"" + p.getUrl() + "\"";
			json += "}";
			first = false;
			
		}
		json += "]}";
		return json;

	}
}
