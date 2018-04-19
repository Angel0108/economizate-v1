package com.economizate;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.economizate.conector.ConectorSaldo;
import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.Criterio;
import com.economizate.servicios.impl.AndCriterio;
import com.economizate.servicios.impl.EgresoCriterio;
import com.economizate.servicios.impl.IngresoCriterio;
import com.economizate.servicios.impl.OrCriterio;
import com.economizate.servicios.impl.RangoFechaCriterio;

public class CriteriosFiltroTest {
	

	private ConectorSaldo conectorSaldo = new ConectorSaldo();
	
	@Test
	public void filtrarMovimientosPorFechaYObtenerListaOK() throws ParseException {
		List<MovimientoMonetario> lista = conectorSaldo.nuevoSaldo().getMovimientos();
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		Date desde = formater.parse("20180301");
		Date hasta = formater.parse("20180501");
		Criterio criterio = new RangoFechaCriterio(desde, hasta);
		List<MovimientoMonetario> listaFiltrada = criterio.filtrarMovimientos(lista);
		 
		assertTrue("Lista filtrada por fecha ", listaFiltrada.get(0).getFecha().before(hasta) &&
				listaFiltrada.get(0).getFecha().after(desde));
	}
	
	@Test
	public void filtrarMovimientosPorIngresoYObtenerListaIngresosOK() throws ParseException {
		List<MovimientoMonetario> lista = conectorSaldo.nuevoSaldo().getMovimientos();
		Criterio criterio = new IngresoCriterio();
		List<MovimientoMonetario> listaFiltrada = criterio.filtrarMovimientos(lista);
		assertTrue("Lista filtrada por ingresos ", listaFiltrada.get(0).getImporte() > 0);
	}
	
	@Test
	public void filtrarMovimientosPorEgresoYObtenerListaEgresosOK() throws ParseException {
		List<MovimientoMonetario> lista = conectorSaldo.nuevoSaldo().getMovimientos();
		Criterio criterio = new EgresoCriterio();
		List<MovimientoMonetario> listaFiltrada = criterio.filtrarMovimientos(lista);
		
		assertTrue("Lista filtrada por egresos ", listaFiltrada.get(0).getImporte() < 0);
	}

	@Test
	public void filtrarMovimientosPorFechaEIngresosYObtenerListaOK() throws ParseException {
		List<MovimientoMonetario> lista = conectorSaldo.nuevoSaldo().getMovimientos();
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		Date desde = formater.parse("20180301");
		Date hasta = formater.parse("20180501");
		Criterio criterioFechas = new RangoFechaCriterio(desde, hasta);
		Criterio criterioIngresos = new IngresoCriterio();
		Criterio criterio = new AndCriterio(criterioIngresos, criterioFechas);
		List<MovimientoMonetario> listaFiltrada = criterio.filtrarMovimientos(lista);
		 
		assertTrue("Lista filtrada por ingresos y fecha ", listaFiltrada.get(0).getFecha().before(hasta) &&
				listaFiltrada.get(0).getFecha().after(desde) && listaFiltrada.get(0).getImporte() > 0);
	}
	
	@Test
	public void filtrarMovimientosPorEgresosOIngresosYObtenerListaOK() throws ParseException {
		List<MovimientoMonetario> lista = conectorSaldo.nuevoSaldo().getMovimientos();
		int cantidadTotal = lista.size();
		
		Criterio criterioIngresos = new IngresoCriterio();
		Criterio criterioEgresos = new EgresoCriterio();
		Criterio criterio = new OrCriterio(criterioIngresos, criterioEgresos);
		List<MovimientoMonetario> listaFiltrada = criterio.filtrarMovimientos(lista);
		
		assertTrue("Lista filtrada por ingresos y egresos ", listaFiltrada.size() == cantidadTotal);
	}
	
}
