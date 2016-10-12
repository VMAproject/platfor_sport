package com.sport.mvc.repozitoriy;

import java.util.List;



import com.sport.mvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class CustomerDAOimpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        //return the results
        return customers;
    }


    @Override
    public void saveCustomer(Customer theCustomer) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        // do the work
        theQuery.executeUpdate();
    }

}