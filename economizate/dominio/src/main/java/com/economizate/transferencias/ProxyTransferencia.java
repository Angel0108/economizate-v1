package com.economizate.transferencias;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class ProxyTransferencia implements ITransferencia{

	private GeneradorTransferencia transferencia;
	
	public ProxyTransferencia() {
		super();
		this.transferencia = new GeneradorTransferencia();
	}

	@Override
	public boolean transferir(double monto) {
		return transferencia.transferir(monto);
	}
	
	@Override
	public int ejecutar(double monto) {
		return transferencia.ejecutar(monto);
	}

}
