package proyectBBDDEnergy.models.dao;

import java.util.List;

import proyectBBDDEnergy.models.entities.Customer;

public interface ICustomerDao {

	List<Customer> findAll();
	void save(Customer customer);
	Customer findOne(Long id);
	void delete(Long id);
}
