package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
//	For save one customer detail
	public String saveCustomer(Customer customer) {
   	 customerRepo.save(customer);
   	 return"Customer details save";
	}
	
	//for save multiple(n number) customer one time
	public List<Customer> saveCustomers(List<Customer>  customers) {
		return customerRepo.saveAll(customers);
   	 
	}
	
	// return from data base to All customer details
	public List<Customer> getCustomers() {
    	return customerRepo.findAll();
     }
	
	// Find customer details by id
		 public Customer getCustomerByid(Integer id) {
		    return customerRepo.findById(id).orElse(null);
		  }
	
	// Find customer details by name
	public Customer getCustomerByName(String name) {
    	return (Customer) customerRepo.findByName(name);
     }
	 
	 // Update customer details by id
	 public Customer updateCustomer( Customer  customer) {
	    Customer existingCustomer = customerRepo.findById(customer.getId()).orElse( null);
	       existingCustomer.setName(customer.getName());
	       existingCustomer.setAge(customer.getAge());
	       existingCustomer.setPhone(customer.getPhone());
	       existingCustomer.setGender(customer.getGender());
	       existingCustomer.setEmail(customer.getEmail());
	       return customerRepo.save(existingCustomer);
	     }
	 
	// Delete customer details by id
	    public String deleteCustomer(Integer id) {
			   customerRepo.deleteById(id);
			   return "Record deleted"+ id;
		}
}
