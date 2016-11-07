package com.sport.mvc.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "list_date")
public class ListDate extends Model{

    private static final long serialVersionUID = 2333403738240612177L;

    public ListDate() {
        super();
    }

}
