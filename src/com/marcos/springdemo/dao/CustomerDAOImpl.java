package com.marcos.springdemo.dao;

import com.marcos.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers()
    {
       Session currentSession = sessionFactory.getCurrentSession();
       Query<Customer> query = currentSession.createQuery("from Customer ORDER BY lastName", Customer.class);
       List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomer(int theId)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer theCustomer = currentSession.get(Customer.class, theId);
        System.out.println("Inside customerDAO grabbing customer with id " + theId + " " + theCustomer.getFirstName());

        return theCustomer;
    }

    @Override
    public void saveCustomer(Customer theCustomer)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        //        This save or update hibernate method will find out if the id of the customer is
        //        already taken and save or update depending on if the customer exists
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public void deleteCustomer(int theId)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Customer where id =: customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
    }
}