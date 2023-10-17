package proyectBBDDEnergy.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import proyectBBDDEnergy.models.entities.Company;
import proyectBBDDEnergy.servicies.ICompanyService;

@Controller
@RequestMapping("/company")
//@SessionAttributes("company")
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService;
	
	@GetMapping("/list")
	public String list(Map<String,Object> model) {
		
		model.put("title", "Company list");
		model.put("companies",companyService.findAll());
		return "company/list";
	}
	
	@GetMapping("/form")
	public String create(Map<String,Object> model) {
		model.put("title", "Company form");
		model.put("company",new Company());
		return "company/form";
		
	}
	@PostMapping("/form")
	public String keep(@Valid Company company,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Company form");
			return "company/form";
		}
				
		companyService.save(company);
		return "redirect:list";
	}
	
	@GetMapping("/form/{id}")
	public String update(@PathVariable("id")Long id,Map<String,Object> model){
		Company company = null;
		if(id<0){
			company = companyService.findOne(id);
		}else {
			return "redirect:/company/list";
		}
		model.put("company", company);
		model.put("title", "Edit form");
		return "company/form";
	}
	
	@GetMapping("/eliminate/{id}")
	public String eliminate (@PathVariable("id") Long id) {
		if(id>0) {
			companyService.delete(id);
		}
		return "redirect:/list";
	}
}
