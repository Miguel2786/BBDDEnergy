package proyectBBDDEnergy.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import proyectBBDDEnergy.models.entities.Company;

@Repository
public class CompanyDaoImpl implements ICompanyDao {
	@PersistenceContext
	private EntityManager em;
	
	//@Transactional(readOnly=true)
	@Override
	public List<Company> findAll(){
		return em.createQuery("from Company",Company.class).getResultList();
	}

	//@Transactional
	@Override
	public void save(Company company) {
		if(company.getId() != null && company.getId() > 0) {
			em.merge(company);
		}else {
		
		em.persist(company);
		}
	}
	
	//@Transactional
	@Override
	public Company findOne(Long id) {
		
		return em.find(Company.class, id);
	}

	//@Transactional
	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}
}
