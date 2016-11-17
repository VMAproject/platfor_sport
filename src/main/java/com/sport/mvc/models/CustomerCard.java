package com.sport.mvc.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_card")
public class CustomerCard extends Model {

    private static final long serialVersionUID = -7420101268348647447L;

    @Column(name ="price")
    private int price;


    @Column(name = "start_abonement")
    private String start;


    @Column(name = "finish_abonement")
    private String finish;

    @Column(name = "status")
    private String status;




    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "student_id")
    private Student student;


    public CustomerCard() {
        super();
    }

    public CustomerCard(int price, String start, String finish,String status, Student student) {
        this.status = status;
        this.start = start;
        this.finish = finish;
        this.price = price;
        this.student = student;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
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
