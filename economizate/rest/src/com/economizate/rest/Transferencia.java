package com.economizate.rest;

import java.util.logging.Logger;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/transferencia")
public class Transferencia {
	
		@Path("/ejecutar")
		@POST
		@Produces("application/json")
		public Response generarTransferencia(@QueryParam("monto") String monto, @QueryParam("destinatario") String destinatario) { 
			
			Logger.getLogger(Transferencia.class.getName()).info("******** Servicio para generar transferencia de"
					+ " monto: " + monto +  " ********");
			
			Logger.getLogger(Transferencia.class.getName()).info("******** Servicio para generar transferencia hacia"
					+ " destinatario: " + destinatario +  " ********");
			
			String request = "Se ha iniciado una transferencia por un monto de: " + monto;
			
			return Response.status(201).build();
			
		}

}
