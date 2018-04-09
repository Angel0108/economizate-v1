package com.economizate.servicios.impl;

import com.economizate.servicios.ValidadorRegistroStrategy;

public class ConcreteValidadorRegistroStrategy implements ValidadorRegistroStrategy {
	
	
	@Override
	public boolean validate(Registro r) {

		if(r.getConcepto().isEmpty()) {
			return false;
		} else if(r.getObservacion().isEmpty()) {
			return false;
		} else if(r.getImporte().isEmpty()) {
			return false;
		}
		try {
			Float.valueOf(r.getImporte());
		} catch (Exception e) {
			return false;
		}		
		return true;
	}

}
