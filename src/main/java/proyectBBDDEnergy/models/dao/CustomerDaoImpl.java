package proyectBBDDEnergy.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import proyectBBDDEnergy.models.entities.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	//@Transactional(readOnly=true)
	@Override
	public List<Customer> findAll(){
		return em.createQuery("from Customer",Customer.class).getResultList();
	}
	//@Transactional
	@Override
	public void save(Customer customer) {
		if(customer.getId() != null && customer.getId() > 0) {
			em.merge(customer);
		}else {
		
		em.persist(customer);
		}
	}
	//@Transactional
	@Override
	public Customer findOne(Long id) {
		
		return em.find(Customer.class, id);
	}
	//@Transactional
	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}
}
