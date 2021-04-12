package com.marcos.springdemo.dao;

import com.marcos.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO
{
    public List<Customer> getCustomers();
}
