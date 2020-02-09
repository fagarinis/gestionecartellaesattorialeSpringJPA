package it.gestionecartellaesattorialeSpringJPA.service;

import java.util.List;

import it.gestionecartellaesattorialeSpringJPA.model.Contribuente;

public interface ContribuenteService {

	public List<Contribuente> listAllContribuenti();

	public Contribuente caricaSingoloContribuente(Long id);

	public void aggiorna(Contribuente o);

	public void inserisciNuovo(Contribuente o);

	public void rimuovi(Contribuente o);

	public List<Contribuente> findByExample(Contribuente example);
	
	public Contribuente trovaDaCf(String cf);

}
