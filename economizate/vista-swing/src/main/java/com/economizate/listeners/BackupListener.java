package com.economizate.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.economizate.batch.BackupArchivo;
import com.economizate.batch.BackupDrive;
import com.economizate.batch.BackupTimer;
import com.economizate.batch.EjecutorBackup;
import com.economizate.batch.IBackup;

public class BackupListener implements ActionListener {
	
	public static final Logger logger = Logger.getLogger(BackupListener.class.getName());
	
	IBackup backupArchivo;
	IBackup backupDrive;
	List<IBackup> listaBackups;

	public BackupListener() {
		
		backupArchivo = new BackupArchivo();
		backupDrive = new BackupDrive();
		
		//Agregar backups necesarios
		listaBackups = Arrays.asList(backupArchivo);
	}
	
	public void actionPerformed(ActionEvent e) {
		logger.info("Inicio Backup historial");
		
		//NO necesito Visitor
		//visitante.visitar(listaBackups); --> antes
		
		new EjecutorBackup(BackupTimer.DEFAULT, listaBackups).ejecutar();
	}

}
