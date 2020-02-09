package it.gestionecartellaesattorialeSpringJPA.dao;

import java.util.List;

import it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale;

public interface CartellaEsattorialeDAO extends IBaseDAO<CartellaEsattoriale> {
	
	public CartellaEsattoriale getEager(long id);
	
	public List<CartellaEsattoriale> findByExampleEager(CartellaEsattoriale example);

}
