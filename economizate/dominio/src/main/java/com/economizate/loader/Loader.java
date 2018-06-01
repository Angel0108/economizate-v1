package com.economizate.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.ServiceLoader;

import com.economizate.servicios.IAlertas;
import com.economizate.servicios.INube;

public class Loader {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
	      
	      /*ClassLoader ldr = Thread.currentThread().getContextClassLoader();
	      Enumeration<URL> e = ldr.getResources("META-INF/services/" + "ConnectorDrive.class");*/
	      ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
	      MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
	      Class myObjectClass = classLoader.loadClass("ConnectorDrive");
	      classLoader.loadClass("NubeEnum");
	      classLoader.loadClass("NubePropiedades");
	      //classLoader.loadClass("ConnectorDrive");
	      //classLoader.loadClass("ConnectorDrive");

	      INube nube = (INube) myObjectClass.newInstance();
	      System.out.println(nube.getTipo());
	      try {
	    	  nube.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
	  }
	
	

}
