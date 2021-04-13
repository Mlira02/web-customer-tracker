package com.marcos.springdemo.service;

import com.marcos.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService
{
    public List<Customer> getCustomers();

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

    public void saveCustomer(Customer theCustomer);
}
