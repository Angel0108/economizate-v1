package com.economizate.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class EjecutorBackup {	
	
	private List<IBackup> backups;
	private BackupTimer frecuencia;
	private Timer timer;
	
	public EjecutorBackup(BackupTimer frecuencia, IBackup... backups) {
		this.frecuencia = frecuencia;
		this.backups = aLista(backups);
		this.timer = new Timer();
	}
	
	public EjecutorBackup(BackupTimer frecuencia, List<IBackup> backups) {
		this.frecuencia = frecuencia;
		this.backups = backups;
		this.timer = new Timer();
	}
	
	public void ejecutar() {
		switch(this.frecuencia) {
		case TRESSEGUNDOS:
			timer.schedule(new ProcesoPeriodico(backups), 0, Long.parseLong("3000"));
			break;
		case CINCOMINUTOS:
			timer.schedule(new ProcesoPeriodico(backups), 0, Long.parseLong("300000"));
			break;
		case DIARIO:
			timer.schedule(new ProcesoPeriodico(backups), 0, 86400000l);
			break;
		case SEMANAL:
			timer.schedule(new ProcesoPeriodico(backups), 0, 604800000l);
			break;
		case MENSUAL:
			timer.schedule(new ProcesoPeriodico(backups), 0, 2419200000l);
			break;
		case ANUAL:
			timer.schedule(new ProcesoPeriodico(backups), 0, 29030400000l);
			break;
		case DEFAULT:
			timer.schedule(new ProcesoPeriodico(backups), 0, 86400000l);
			break;
		default:
			timer.schedule(new ProcesoPeriodico(backups), 0, 86400000l);
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
