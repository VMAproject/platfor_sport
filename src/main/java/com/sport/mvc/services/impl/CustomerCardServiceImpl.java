package com.sport.mvc.services.impl;

import com.sport.mvc.dao.CustomerCardDao;
import com.sport.mvc.models.CustomerCard;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.CustomerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerCardService")
public class CustomerCardServiceImpl implements CustomerCardService {

    @Autowired
    @Qualifier("customerCardDatabaseDao")
    private CustomerCardDao customerCardDao;

    @Transactional
    @Override
    public List<CustomerCard> getAll() {
        return customerCardDao.getAll();
    }

    @Transactional
    @Override
    public void addCustomerCard(CustomerCard customerCard) {
customerCardDao.add(customerCard);
    }

    @Transactional
    @Override
    public void deleteListOfCustomerCards(Long id) {
        customerCardDao.remove(customerCardDao.getById(id));

    }

    @Transactional
    @Override
    public CustomerCard getCustomerCardt(long theId) {
        return customerCardDao.getById(theId);
    }

    @Transactional
    @Override
    public void updateCustomerCard(CustomerCard customerCard) {
        customerCardDao.update(customerCard);

    }
}
