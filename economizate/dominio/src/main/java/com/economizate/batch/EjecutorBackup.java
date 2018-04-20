package com.economizate.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class EjecutorBackup {	
	
	private IVisitor visitante;
	private List<IBackup> backups;
	private BackupTimer frecuencia;
	private Timer timer;
	
	public EjecutorBackup(IVisitor visitante, BackupTimer frecuencia, IBackup... backups) {
		this.visitante = visitante;
		this.frecuencia = frecuencia;
		this.backups = aLista(backups);
		this.timer = new Timer();
	}
	
	public EjecutorBackup(IVisitor visitante, BackupTimer frecuencia, List<IBackup> backups) {
		this.visitante = visitante;
		this.frecuencia = frecuencia;
		this.backups = backups;
		this.timer = new Timer();
	}
	
	public void ejecutar() {
		switch(this.frecuencia) {
		case DIARIO:
			timer.schedule(new ProcesoPeriodico(visitante, backups), 1000, Long.parseLong("5184000000"));
			break;
		case DEFAULT:
			timer.schedule(new ProcesoPeriodico(visitante, backups), 1000, 5000);
			break;
		default:
			timer.schedule(new ProcesoPeriodico(visitante, backups), 3000, Long.parseLong("5184000000"));
			break;
		}
		
	}
	
	private List<IBackup> aLista(IBackup... backups){
		List<IBackup> lista = new ArrayList<>();
		for(IBackup b : backups) {
			lista.add(b);
		}
		return lista;
	}
}
