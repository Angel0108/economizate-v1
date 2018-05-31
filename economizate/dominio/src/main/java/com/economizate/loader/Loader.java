package com.economizate.loader;

import java.lang.reflect.InvocationTargetException;
import java.util.ServiceLoader;

import com.economizate.servicios.IAlertas;

public class Loader {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	      ServiceLoader<IAlertas> serviceLoader =
	              ServiceLoader.load(IAlertas.class);
	      
	      for (IAlertas alerta : serviceLoader) {
	  		Object obj = alerta;
	        System.out.println(obj.toString());
	      }
	  }

}
