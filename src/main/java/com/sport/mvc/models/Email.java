package com.sport.mvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "email")
public class Email extends Model{

    private static final long serialVersionUID = -7486118229572988320L;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "created")
    private Date created;

    public Email() {
        super();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (name != null ? !name.equals(email.name) : email.name != null) return false;
        if (message != null ? !message.equals(email.message) : email.message != null) return false;
        return created != null ? created.equals(email.created) : email.created == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
