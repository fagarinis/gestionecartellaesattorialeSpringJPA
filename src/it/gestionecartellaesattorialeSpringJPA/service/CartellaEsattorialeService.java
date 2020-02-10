package it.gestionecartellaesattorialeSpringJPA.service;

import java.util.List;

import it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale;

public interface CartellaEsattorialeService {

	public List<CartellaEsattoriale> listAllCartelleEsattoriali();
	
	public List<CartellaEsattoriale> listAllCartelleEsattorialiEager();

	public CartellaEsattoriale caricaSingolaCartellaEsattoriale(Long id);

	public void aggiorna(CartellaEsattoriale o);

	public void inserisciNuovo(CartellaEsattoriale o);

	public void rimuovi(CartellaEsattoriale o);

	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example);
	
	public List<CartellaEsattoriale> findByExampleEager(CartellaEsattoriale example);
	
	public CartellaEsattoriale caricaSingolaCartellaEsattorialeEager(Long id);

}
