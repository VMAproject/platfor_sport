package com.sport.mvc.repozitoriy;

import com.sport.mvc.entity.Customer;

import java.util.List;



public interface CustomerDAO {
	
	 List<Customer> getCustomers();

	 void saveCustomer(Customer theCustomer);

	 Customer getCustomer(int theId);

	 void deleteCustomer(int theId);;

}
