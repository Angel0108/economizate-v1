package com.economizate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.economizate.transferencias.GeneradorTransferencia;
import com.economizate.transferencias.ITransferencia;
import com.economizate.transferencias.ProxyTransferencia;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class RestTest {
	
	@Test
	public void generarTransferenciaConMonto100YConExito(){
		ITransferencia transferencia = new ProxyTransferencia();
		
		boolean result = transferencia.transferir(Double.valueOf(100));
		
		assertTrue("Transferencia realizada: ", result);
	}
	
	@Test
	public void generarTransferenciaConMonto100YRecibirStatus201(){
		ITransferencia transferencia = new ProxyTransferencia();
		
		int result = transferencia.ejecutar(Double.valueOf(100));
		
		assertTrue("Transferencia realizada: ", result == 201);
	}

}
