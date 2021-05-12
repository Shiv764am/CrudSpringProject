package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Customer;
import com.example.demo.service.CustomerService;

import java.util.List;


@RestController
public class CustomerController {
	@Autowired CustomerService service;
	
//	For save one customer detail
     @PostMapping("/addCustomer")
	public String insertCustomer(@RequestBody Customer customer) {
    	 return service.saveCustomer(customer);
    	 
	}
     //for save multiple(n number) customer one time
     @PostMapping("/addCustomers")
     public List<Customer> insertCustomers(@RequestBody  List<Customer>  customers) {
    	 return service.saveCustomers(customers);
    	 
	}
     
     // return from data base to All customer details
     @GetMapping("/customers")
     public List<Customer> findAllCustomers() {
    	return service.getCustomers();
     }
     
  // Find customer details by id
     @GetMapping("/customerById/{id}")
     public Customer findCustomerByid(@PathVariable Integer id) {
    	return service.getCustomerByid(id);
     }
     
  // Find customer details by name
     @GetMapping("/customer/{name}")
     public Customer findCustomerByName(@PathVariable String name) {
    	return service.getCustomerByName(name);
     }
     
  // Update customer details
     @PutMapping("/update")
     public Customer updateCustomer(@RequestBody Customer customer) {
       return service.updateCustomer(customer);
       
     }

  // Delete customer detail by id
     @DeleteMapping("/delete/{id}")
     public String deleteCustomer(@PathVariable Integer id) {
    	 return service.deleteCustomer(id);
     }
}
