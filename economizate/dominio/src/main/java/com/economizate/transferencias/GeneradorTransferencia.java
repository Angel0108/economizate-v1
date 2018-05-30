package com.economizate.transferencias;

import java.io.IOException;
import java.util.Date;

import org.json.JSONObject;

import com.economizate.entidades.Cuenta;
import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.impl.Propiedad;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class GeneradorTransferencia implements ITransferencia{
	
	private Cuenta cuenta;
	
	public GeneradorTransferencia(Cuenta cuenta) {
		super();
		this.cuenta = cuenta;
	}

	@Override
	public boolean transferir(double monto, String destinatario) {
		boolean result = false;
		
		try {
			//genero url rest
			HttpRequest request = Unirest.post(Propiedad.getInstance().getPropiedad("endpoint"))
			  .header("accept", "application/json")
			  .queryString("destinatario", "pepaGonzalez@gmail.com")
			  .queryString("monto", String.valueOf(monto));
			  
			
			HttpResponse<JsonNode> response = request.asJson();
			System.out.println(request.getUrl());
			
			
			result = true;
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		generarEgreso(monto);
		return result;
	}
	
	@Override
	public int ejecutar(double monto, String destinatario) {
		HttpResponse<JsonNode> response = null;
		
		try {
			//genero url rest
			HttpRequestWithBody request = Unirest.post(Propiedad.getInstance().getPropiedad("endpoint"))
					.queryString("destinatario", destinatario)
					  .queryString("monto", String.valueOf(monto));
			
			response = request.asJson();
			System.out.println(request.getUrl());
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		generarEgreso(monto);
		return response.getStatus();
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public void generarEgreso(double monto) {
		
		MovimientoMonetario egreso = 
				new MovimientoMonetario("Transferencia", "Terceros", -monto, new Date());
		
		cuenta.getMovimientos().agregarMovimiento(egreso);
		cuenta.modificarTotal(cuenta.getMovimientos().getTotal());
		
		cuenta.setTotal(cuenta.getTotal());
	}

}
