package dao;

import java.util.List;

import entity.Customer;

public interface CustomerDAO {
	public boolean insertCustomer(Customer c);
	
	public List<Customer> getListCustomer(); 
	
	public Customer getCustomerById(int id);
	
	public boolean saveCustomer(Customer c);
}
