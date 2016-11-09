package com.sport.mvc.services.impl;

import com.sport.mvc.dao.PriceDao;
import com.sport.mvc.models.Price;
import com.sport.mvc.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("priceService")
public class PriceServiceImpl implements PriceService {

    @Autowired
    @Qualifier("priceDatabaseDao")
    private PriceDao priceDao;

    @Override
    @Transactional
    public List<Price> getAll() {
        return priceDao.getAll();
    }

    @Override
    @Transactional
    public void addPrice(Price price) {
  priceDao.add(price);
    }

    @Override
    @Transactional
    public void deleteListOfSPrice(Long id) {
        priceDao.remove(priceDao.getById(id));
    }

    @Override
    @Transactional
    public Price getPricece(long theId) {
        return priceDao.getById(theId);
    }

    @Override
    @Transactional
    public void updatePrice(Price price) {

    }

    @Override
    public void deleteListOfPrice(Long id) {
        priceDao.remove(priceDao.getById(id));
    }
}
