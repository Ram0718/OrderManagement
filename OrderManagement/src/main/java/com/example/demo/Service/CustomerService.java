package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repo.CustomerRepo;
import com.example.demo.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo cr;
	 public Customer addingCustomer(Customer c) {
		return cr.save(c);
	 }
	public List<Customer> getAllCustomers(){
		return cr.findAll();
	}
	public Customer getCustomerById(long id) {
		return cr.findById(id).orElseThrow(()-> new RuntimeException("customer not found with this id  "+id));
	}
	public Customer updateCustomerById( long id,Customer c) {
		Customer ec=cr.findById(id).orElseThrow(()-> new RuntimeException("customer not found with this "+id));
		ec.setEmail(c.getEmail());
		ec.setName(c.getName());
		ec.setPhone(c.getPhone());
		return cr.save(ec);
	}
	public String deletById( long id) {
	cr.deleteById(id);
	return "Customer deleted successfully";
	}
}
