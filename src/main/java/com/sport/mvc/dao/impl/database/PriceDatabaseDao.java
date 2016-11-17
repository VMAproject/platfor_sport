package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.PriceDao;
import com.sport.mvc.models.Price;
import org.springframework.stereotype.Repository;

@Repository(value = "priceDatabaseDao")
public class PriceDatabaseDao extends HibernateAbstractDao<Price> implements PriceDao {

    public PriceDatabaseDao() {
    }
}
