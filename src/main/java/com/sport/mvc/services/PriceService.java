package com.sport.mvc.services;

import com.sport.mvc.models.Price;

import java.util.List;

/**
 * Created by bjj on 09.11.2016.
 */
public interface PriceService {

    List<Price> getAll();

    void addPrice(Price price);

    void deleteListOfSPrice(Long id);

    Price getPricece(long theId);

    void updatePrice(Price price);

    void deleteListOfPrice(Long id);
}
