package com.economizate;

import java.text.ParseException;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.economizate.entidades.MovimientoMonetario;
import com.economizate.servicios.impl.ConcreteValidadorRegistroStrategy;
import com.economizate.servicios.impl.ExcelReader;
import com.economizate.servicios.impl.ParserRegistroMovimiento;

public class ParserTest {

	@Test@Ignore
	public void parserExcel() throws ParseException {
		
		ExcelReader parser = new ExcelReader("C:\\Users\\Nico\\Desktop\\prueba.xlsx");
		String resultado = parser.Read();		
		ParserRegistroMovimiento parser2 = new ParserRegistroMovimiento(resultado, ";");
		MovimientoMonetario mov = parser2.parse();
		mov.setValidador(new ConcreteValidadorRegistroStrategy());
		Assert.assertTrue(mov.isValid());
	}
}
