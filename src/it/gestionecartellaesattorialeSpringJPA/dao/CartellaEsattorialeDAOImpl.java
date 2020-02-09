package it.gestionecartellaesattorialeSpringJPA.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.gestionecartellaesattorialeSpringJPA.model.CartellaEsattoriale;

@Component
public class CartellaEsattorialeDAOImpl implements CartellaEsattorialeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CartellaEsattoriale> list() {
		return em.createQuery("From CartellEsattoriale", CartellaEsattoriale.class).getResultList();
	}

	@Override
	public CartellaEsattoriale get(long id) {
		return em.find(CartellaEsattoriale.class, id);
	}

	@Override
	public void update(CartellaEsattoriale o) {
		o = em.merge(o);
	}

	@Override
	public void insert(CartellaEsattoriale o) {
		em.persist(o);
	}

	@Override
	public void delete(CartellaEsattoriale o) {
		em.remove(em.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale o) {
		Session session = (Session) em.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if (object == null)
					return false;
				// String
				if (object instanceof String)
					return StringUtils.isNotBlank((String) object);
				// Number
				if (object instanceof Integer)
					return ((Integer) object) != 0;
				return true;
			}
		};

		Criteria cartellaEsattorialeCriteria = session.createCriteria(CartellaEsattoriale.class);
		Example cartellaEsattorialeExample = Example.create(o).setPropertySelector(ps);
		if (o.getContribuente() != null) {
			cartellaEsattorialeCriteria.createCriteria("contribuente").add(Example.create(o.getContribuente()));
		}

		cartellaEsattorialeCriteria.add(cartellaEsattorialeExample);
		return cartellaEsattorialeCriteria.list();
	}

	@Override
	public CartellaEsattoriale getEager(long id) {
		return em.createQuery("From CartellaEsattoriale c " + "join fetch c.contribuente where c.id = '" + id + "'",
				CartellaEsattoriale.class).getSingleResult();
	}

	@Override
	public List<CartellaEsattoriale> findByExampleEager(CartellaEsattoriale example) {
		List<CartellaEsattoriale> result = new ArrayList<>();
		if (example == null) {
			return result;
		}

		String query = "From CartellaEsattoriale ca join fetch ca.contribuente c where 1=1";
		if (example.getDenominazione() != null && example.getDenominazione() != "") {
			query += " and ca.denominazione = '" + example.getDenominazione() + "'";
		}
		if (example.getDescrizione() != null && example.getDescrizione() != "") {
			query += " and ca.descrizione = '" + example.getDescrizione() + "'";
		}
		if (example.getImporto() != null) {
			query += " and ca.importo = " + example.getImporto() + "";
		}
		if (example.getContribuente() != null && example.getContribuente().getCf() != null
				&& example.getContribuente().getCf() != "") {
			query += " and c.cf = '" + example.getContribuente().getCf() + "'";
		}

		result = em.createQuery(query, CartellaEsattoriale.class).getResultList();
		return result;
	}

}
