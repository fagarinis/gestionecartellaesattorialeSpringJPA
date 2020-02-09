package it.gestionecartellaesattorialeSpringJPA.dao;

import it.gestionecartellaesattorialeSpringJPA.model.Contribuente;

public interface ContribuenteDAO extends IBaseDAO<Contribuente> {
	
	public Contribuente findByCf(String cf);
	
}
