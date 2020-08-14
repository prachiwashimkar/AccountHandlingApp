package com.example.AccountHandlingApp.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.AccountHandlingApp.Entities.Customer;
import com.example.AccountHandlingApp.Service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/customers")
	public ModelAndView getAllCustomers(ModelAndView modelAndView){
		System.out.println("inside getallcustomers");
		modelAndView.addObject("allCustomers", customerService.getAllCustomers());
		modelAndView.setViewName("customerInfo");
		return modelAndView;
	}
	
	@GetMapping(value="/customers/{customerId}")
	public ModelAndView getCustomerById(@PathVariable Integer customerId, ModelAndView modelAndView){
		Customer customer = new Customer();
		customer = customerService.getCustomerById(customerId);
		
		modelAndView.addObject("customer", customer);
		modelAndView.setViewName("customerInfo");
		return modelAndView;
	}
	
	@GetMapping(value="/addCustomer")
	public ModelAndView createCustomerView(ModelAndView modelAndView){
		modelAndView.setViewName("createCustomer");
		modelAndView.addObject("customer", new Customer());
		
		return modelAndView;
	}
	
	@PostMapping(value="/addCustomer")
	public ModelAndView createCustomer(@Valid Customer customer, BindingResult result, ModelAndView modelAndView){
		
		if(result.hasErrors()){
			modelAndView.setViewName("createCustomer");
			modelAndView.addObject("customer", customer);
			return modelAndView;
		}
		
		customerService.addCustomer(customer);
		modelAndView.addObject("allCustomers", customerService.getAllCustomers());
		modelAndView.setViewName("customerInfo");
		return modelAndView;
	}
	
	@PutMapping(value="/updateCustomer/{customerId}")
	public ModelAndView updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer, ModelAndView modelAndView){
		System.out.println("Inside update customer");
		System.out.println(customer.getFirstName() + "=" +customer.getLastName());
		customerService.updateCustomer(customerId, customer);
		modelAndView.addObject("allCustomers", customerService.getAllCustomers());
		modelAndView.setViewName("customerInfo");
		return modelAndView;
	}
	
	@DeleteMapping(value="/deleteCustomer/{customerId}")
	public ModelAndView deleteCustomer(@PathVariable Integer customerId){
		System.out.println("Inside deleteC");
		customerService.deleteCustomer(customerId);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allCustomers", customerService.getAllCustomers());
		modelAndView.setViewName("customerInfo");
		return modelAndView;
		
	}
}