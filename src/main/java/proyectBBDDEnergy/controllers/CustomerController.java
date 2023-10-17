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
import proyectBBDDEnergy.servicies.ICustomerService;
import proyectBBDDEnergy.models.entities.Customer;

@Controller
@RequestMapping("/customer")
//@SessionAttributes("customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/list")
	public String list(Map<String,Object> model) {
		
		model.put("title", "customer list");
		model.put("customers", customerService.findAll());
		
		return "customer/list";
		
	}
	
	@GetMapping("/form")
	public String create(Map<String,Object> model) {
		model.put("title", "Customer form");
		model.put("customer", new Customer());
		return "customer/form";
	}
	
	@PostMapping("/form")
	public String keep(@Valid Customer customer,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title","Customer form");
			return "customer/form";
		}
		
		customerService.save(customer);
		return "redirect:list";
	}
		
	@GetMapping("/form/{id}")
	public String update(@PathVariable("id")Long id,Map<String,Object> model){
		Customer customer = null;
		if(id>0) {
			customer = customerService.findOne(id);
			
		}else {
			return "redirect:/customer/list";
		}
		model.put("customer",customer);
		model.put("title", "Edit form");
		return "customer/form";
	}
	

	@GetMapping("/eliminate/{id}")
	public String eliminate (@PathVariable("id") Long id) {
		if(id>0) {
			customerService.delete(id);
		}
		return "redirect:/list";
	}
}
