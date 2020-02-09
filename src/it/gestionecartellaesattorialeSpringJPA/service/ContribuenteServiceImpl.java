package it.gestionecartellaesattorialeSpringJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestionecartellaesattorialeSpringJPA.dao.ContribuenteDAO;
import it.gestionecartellaesattorialeSpringJPA.model.Contribuente;

@Service
public class ContribuenteServiceImpl implements ContribuenteService {

	@Autowired
	private ContribuenteDAO contribuenteDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Contribuente> listAllContribuenti() {
		return contribuenteDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Contribuente caricaSingoloContribuente(Long id) {
		return contribuenteDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Contribuente o) {
		contribuenteDAO.update(o);
	}

	@Transactional
	@Override
	public void inserisciNuovo(Contribuente o) {
		contribuenteDAO.insert(o);
	}

	@Transactional
	@Override
	public void rimuovi(Contribuente o) {
		contribuenteDAO.delete(o);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Contribuente> findByExample(Contribuente example) {
		return contribuenteDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	@Override
	public Contribuente trovaDaCf(String cf) {
		return contribuenteDAO.findByCf(cf);
	}

}
