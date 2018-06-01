package com.economizate.nubeManager;

import java.io.IOException;
import java.util.List;

import com.economizate.servicios.INube;
import com.google.api.services.drive.model.File;

public class ConnectorOneDrive implements INube{

	@Override
	public boolean conectar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upload(String pathFile) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Enum<?> getTipo() {
		return NubeEnum.ONEDRIVE;
	}

	@Override
	public String uploadId(String pathFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> leerArchivos() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
