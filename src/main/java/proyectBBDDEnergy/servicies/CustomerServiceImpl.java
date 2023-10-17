package proyectBBDDEnergy.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectBBDDEnergy.models.dao.ICustomerDao;
import proyectBBDDEnergy.models.entities.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	ICustomerDao customerDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findOne(Long id) {
		
		return customerDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		customerDao.delete(id);
		
	}

}
