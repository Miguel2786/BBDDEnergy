package proyectBBDDEnergy.servicies;

import java.util.List;

import proyectBBDDEnergy.models.entities.Customer;

public interface ICustomerService {
	List<Customer> findAll();
	void save (Customer customer);
	Customer findOne(Long id);
	void delete(Long id);
}
