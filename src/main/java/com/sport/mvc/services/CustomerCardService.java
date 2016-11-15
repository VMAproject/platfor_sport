package com.sport.mvc.services;

import com.sport.mvc.models.CustomerCard;
import com.sport.mvc.models.Student;

import java.util.List;

/**
 * Created by bjj on 15.11.2016.
 */
public interface CustomerCardService {

    List<CustomerCard> getAll();

    void addCustomerCard(CustomerCard customerCard);

    void deleteListOfCustomerCards(Long id);

    CustomerCard getCustomerCardt(long theId);

    void updateCustomerCard(CustomerCard cusromerCard);
}
