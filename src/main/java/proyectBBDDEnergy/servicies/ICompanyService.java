package proyectBBDDEnergy.servicies;

import java.util.List;

import proyectBBDDEnergy.models.entities.Company;

public interface ICompanyService {
	List<Company> findAll();
	void save(Company company);
	Company findOne(Long id);
	void delete(Long id);
}
