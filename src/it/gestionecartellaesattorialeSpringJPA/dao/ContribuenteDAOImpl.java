package it.gestionecartellaesattorialeSpringJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.Order;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.gestionecartellaesattorialeSpringJPA.model.Contribuente;

@Component
public class ContribuenteDAOImpl implements ContribuenteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Contribuente> list() {
		return em.createQuery("From Contribuente c order by c.cognome", Contribuente.class).getResultList();
	}

	@Override
	public Contribuente get(long id) {
		return em.find(Contribuente.class, id);
	}

	@Override
	public void update(Contribuente o) {
		o = em.merge(o);
	}

	@Override
	public void insert(Contribuente o) {
		em.persist(o);
	}

	@Override
	public void delete(Contribuente o) {
		em.remove(em.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> findByExample(Contribuente o) {
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

		Example contribuenteExample = Example.create(o).setPropertySelector(ps);

		Criteria criteria = session.createCriteria(Contribuente.class).add(contribuenteExample);
		criteria.addOrder(Order.asc("cognome"));

		return criteria.list();
	}

	@Override
	public Contribuente findByCf(String cf) {
		try {
			return em.createQuery("from Contribuente c where c.cf ='" + cf + "'", Contribuente.class)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
