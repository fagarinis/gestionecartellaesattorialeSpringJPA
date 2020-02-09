package it.gestionecartellaesattorialeSpringJPA.dao;

import it.gestionecartellaesattorialeSpringJPA.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente executeLogin(String username, String password);
}
