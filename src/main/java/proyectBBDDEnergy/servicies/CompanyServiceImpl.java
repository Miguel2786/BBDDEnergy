package proyectBBDDEnergy.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectBBDDEnergy.models.dao.ICompanyDao;
import proyectBBDDEnergy.models.entities.Company;

@Service
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	ICompanyDao companyDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Company> findAll() {
		
		return companyDao.findAll();
	}

	@Override
	@Transactional
	public void save(Company company) {
		companyDao.save(company);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Company findOne(Long id) {
		
		return companyDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		companyDao.delete(id);
	}

}
