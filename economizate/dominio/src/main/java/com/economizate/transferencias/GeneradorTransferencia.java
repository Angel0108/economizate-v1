package com.economizate.transferencias;

import com.economizate.servicios.impl.Propiedad;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

public class GeneradorTransferencia implements ITransferencia{
	
	@Override
	public boolean transferir(double monto) {
		boolean result = false;
		HttpResponse<JsonNode> response = null;
		
		try {
			
			HttpRequest request = Unirest.post(Propiedad.getInstance().getPropiedad("endpoint"))
			  .header("accept", "application/json")
			  .routeParam("monto", String.valueOf(monto));
			
			response = request.asJson();
			
			System.out.println(request.getUrl());
			
			result = true;
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int ejecutar(double monto) {
		boolean result = false;
		HttpResponse<JsonNode> response = null;
		
		try {
			
			HttpRequest request = Unirest.post(Propiedad.getInstance().getPropiedad("endpoint"))
			  .header("accept", "application/json")
			  .routeParam("monto", String.valueOf(monto));
			
			response = request.asJson();
			
			System.out.println(request.getUrl());
			
			result = true;
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return response.getStatus();
	}

}
