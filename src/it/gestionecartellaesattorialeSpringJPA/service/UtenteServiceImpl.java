package it.gestionecartellaesattorialeSpringJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestionecartellaesattorialeSpringJPA.dao.UtenteDAO;
import it.gestionecartellaesattorialeSpringJPA.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDAO utenteDAO;

	@Transactional(readOnly = true)
	public List<Utente> listAllUtenti() {
		return null;
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloUtente(Long id) {
		return null;
	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {

	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		utenteDAO.insert(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {

	}

	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente example) {
		return null;
	}

	@Transactional(readOnly = true)
	public Utente eseguiAccesso(String username, String password) {
		return utenteDAO.executeLogin(username, password);
	}

}
