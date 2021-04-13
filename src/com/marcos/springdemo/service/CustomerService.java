package com.marcos.springdemo.service;

import com.marcos.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService
{
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
