package com.economizate;

import static org.junit.Assert.assertTrue;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.economizate.AlertaTest.ObservadorVistaTest;
import com.economizate.conector.ConectorCuenta;
import com.economizate.entidades.Alerta;
import com.economizate.entidades.Cuenta;
import com.economizate.servicios.FactoryAlertas;
import com.economizate.servicios.impl.UsuariosImpl;
import com.economizate.transferencias.ITransferencia;
import com.economizate.transferencias.ProxyTransferencia;

public class RestTest {
	
	public double saldoAnterior;
	public double saldoActual;
	private Cuenta cuenta;
	public Alerta alerta;
	
	@Before
	public void generarCuenta() {
		cuenta = new ConectorCuenta().nuevaCuenta();
		
		saldoAnterior = cuenta.getTotal();
		
		cuenta.addObserver(new ObservadorVistaTest(saldoAnterior));
	}
	
	@Ignore@Test
	public void generarTransferenciaConMonto100YConExitoConAlarmaRoja(){
		ITransferencia transferencia = new ProxyTransferencia(cuenta);
		
		//transferir returna true si el servicio responde ok
		boolean result = transferencia.transferir(Double.valueOf(100), "pepa@gmail.com");
		
		assertTrue("Transferencia realizada: ", result);
		assertTrue("La alerta generada es de tipo roja: ", alerta.getMensaje().equals("Ha superado el 95%"));
	}
	
	@Ignore@Test
	public void generarTransferenciaConMonto100YRecibirStatus201ConAlarmaRoja(){
		ITransferencia transferencia = new ProxyTransferencia(cuenta);
		
		//ejecutar retorna http status 
		int result = transferencia.ejecutar(Double.valueOf(100), "pepa@gmail.com");
		
		assertTrue("Transferencia realizada con status: ", result == 201);
		assertTrue("La alerta generada es de tipo roja: ", alerta.getMensaje().equals("Ha superado el 95%"));
	}
	
	@Ignore@Test
	public void generarTransferenciaConMonto50YRecibirStatus201ConAlarmaVerde(){
		ITransferencia transferencia = new ProxyTransferencia(cuenta);
		
		//ejecutar retorna http status 
		int result = transferencia.ejecutar(Double.valueOf(50), "pepaGonzalez@gmail.com");
		
		assertTrue("Transferencia realizada con status: ", result == 201);
		assertTrue("La alerta generada es de tipo verde: ", alerta.getMensaje().equals("Transacción OK"));
	}
	
	@Ignore@Test
	public void generarTransferenciaConMonto150YRecibirStatus201ConAlarmaNegra(){
		ITransferencia transferencia = new ProxyTransferencia(cuenta);
		
		//ejecutar retorna http status 
		int result = transferencia.ejecutar(Double.valueOf(150), "pepa@gmail.com");
		
		assertTrue("Transferencia realizada con status: ", result == 201);
		assertTrue("La alerta generada es de tipo negra: ", alerta.getMensaje().equals("Supera el saldo total"));
	}
	
	@Test
	public void generarTransferenciaConMailNoexisteYRecibirErrorArgumentoIlegal(){
		ITransferencia transferencia = new ProxyTransferencia(cuenta);
		
		try {
			//valido mail
			String mailDestinatario = new UsuariosImpl().buscarUsuarioPorEmail("pepa@Gmail.com").getEmail();
			
			//ejecutar retorna http status 
			int result = transferencia.ejecutar(Double.valueOf(150), mailDestinatario);
			assertTrue("Mail existente: ", mailDestinatario != null);
			assertTrue("Transferencia realizada con status: ", result == 201);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			assertTrue("Mail INexistente: ", e.getMessage().equals("Email no coincidente: " + "pepa@Gmail.com"));
		}
		
	}
	
	
	//Observador para alertas
	public class ObservadorVistaTest implements Observer{
		double saldoAnterior;
		FactoryAlertas creadorAlertas = new FactoryAlertas();
		
		public ObservadorVistaTest(double saldoAnterior) {
			this.saldoAnterior = saldoAnterior;
		};

		@Override
		public void update(Observable arg0, Object arg1) {
			alerta = creadorAlertas.crearAlerta(saldoAnterior, (Double) arg1);
		}
	}

}
