package com.economizate.batch;

import java.io.IOException;

import com.economizate.servicios.Cuenta;
import com.economizate.servicios.Usuarios;
import com.economizate.servicios.impl.CuentaImpl;
import com.economizate.servicios.impl.Propiedad;
import com.economizate.servicios.impl.TXTWriter;
import com.economizate.servicios.impl.UsuariosImpl;

public class BackupArchivo implements IBackup{

	Usuarios usuarios = new UsuariosImpl();
	Cuenta cuenta = new CuentaImpl();
	private String path;
	
	public BackupArchivo(String path) {
		this.path = path;
	}
	
	@Override
	public void generarBackupMovimientos() {
		try {
			new TXTWriter(path + "backup-" + System.currentTimeMillis() + ".txt")
			.write(cuenta.obtenerHistorialMovimientos().toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
