package com.sport.mvc.service;

import com.sport.mvc.entity.Customer;

import java.util.List;



public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
