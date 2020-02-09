package it.gestionecartellaesattorialeSpringJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestionecartellaesattorialeSpringJPA.dao.CartellaEsattorialeDAO;
import it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale;

@Service
public class CartellaEsattorialeServiceImpl implements CartellaEsattorialeService {

	@Autowired
	private CartellaEsattorialeDAO cartellaEsattorialeDAO;

	@Transactional(readOnly = true)
	@Override
	public List<CartellaEsattoriale> listAllCartelleEsattoriali() {
		return cartellaEsattorialeDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public CartellaEsattoriale caricaSingolaCartellaEsattoriale(Long id) {
		return cartellaEsattorialeDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(CartellaEsattoriale o) {
		cartellaEsattorialeDAO.update(o);
	}

	@Transactional
	@Override
	public void inserisciNuovo(CartellaEsattoriale o) {
		cartellaEsattorialeDAO.insert(o);
	}

	@Transactional
	@Override
	public void rimuovi(CartellaEsattoriale o) {
		cartellaEsattorialeDAO.delete(o);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example) {
		return cartellaEsattorialeDAO.findByExample(example);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<CartellaEsattoriale> findByExampleEager(CartellaEsattoriale example) {
		return cartellaEsattorialeDAO.findByExampleEager(example);
	}

	@Transactional(readOnly = true)
	@Override
	public CartellaEsattoriale caricaSingolaCartellaEsattorialeEager(Long id) {
		return cartellaEsattorialeDAO.getEager(id);
	}

}
