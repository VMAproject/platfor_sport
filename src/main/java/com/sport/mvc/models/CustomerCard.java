package com.sport.mvc.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_card")
public class CustomerCard extends Model {

    private static final long serialVersionUID = -7420101268348647447L;

    @Column(name = "status")
    private String comment;

    @Column(name = "start_abonement")
    private Date created;


    @Column(name = "finish_abonement")
    private boolean deleted;

    @Column(name ="price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "student_id")
    private Student student;


    public CustomerCard() {
        super();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
