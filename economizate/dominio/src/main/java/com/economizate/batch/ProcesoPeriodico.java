package com.economizate.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ProcesoPeriodico extends TimerTask{
	
	private IVisitor visitante;
	List<IBackup> listaBackups;
	
	
	public ProcesoPeriodico(IVisitor visitante, IBackup... backups) {
		this.visitante = visitante;
		this.listaBackups = aLista(backups);
	}
	
	public ProcesoPeriodico(IVisitor visitante, List<IBackup> backups) {
		this.visitante = visitante;
		this.listaBackups = backups;
	}
	
	@Override
	public void run() {
		System.out.println("descarga archivo");
		visitante.visitar(listaBackups);
	}
	
	private List<IBackup> aLista(IBackup... backups){
		List<IBackup> lista = new ArrayList<>();
		for(IBackup b : backups) {
			lista.add(b);
		}
		return lista;
	}

}
