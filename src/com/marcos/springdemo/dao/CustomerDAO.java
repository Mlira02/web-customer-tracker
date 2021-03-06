package com.marcos.springdemo.dao;

import com.marcos.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO
{
    public List<Customer> getCustomers();

    public Customer getCustomer(int theId);

    public void saveCustomer(Customer theCustomer);

    public void deleteCustomer(int theId);


}
