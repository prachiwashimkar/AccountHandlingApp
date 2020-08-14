package com.example.AccountHandlingApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AccountHandlingApp.Dao.CustomerDao;
import com.example.AccountHandlingApp.Entities.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();
	}
	
	public Customer getCustomerById(Integer customerId){
		return customerDao.findById(customerId).get();
	}
	
	public void addCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	public void updateCustomer(Integer customerId, Customer customer){
		Customer customerToUpdate = customerDao.getOne(customerId);
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setAddress(customer.getAddress());
		customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
		customerToUpdate.setAmount(customer.getAmount());
		customerDao.save(customerToUpdate);
	}
	
	public void deleteCustomer(Integer customerId){
		customerDao.deleteById(customerId);
	}

}
