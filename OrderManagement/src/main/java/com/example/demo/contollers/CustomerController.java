package com.example.demo.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.CustomerService;
import com.example.demo.entity.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer c) {
		return cs.addingCustomer(c);
	}
	@GetMapping
	  public List<Customer> getAll() {
        return cs.getAllCustomers();
    }
	@GetMapping("/{id}")
	public Customer getById(@PathVariable long id){
		return cs.getCustomerById(id);
	}
     @DeleteMapping("/{id}")
     public String deletById(@PathVariable long id) {
    	 cs.deletById(id);
    	 return "Customer was deleted SucessFully with id "+id;
     }
     @PutMapping("/{id}")
     public Customer updateById(@PathVariable long id,@RequestBody Customer c) {
    	return cs.updateCustomerById(id, c);
     }
	

}
