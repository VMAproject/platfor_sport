package com.sport.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "price")
public class Price extends Model{

    private static final long serialVersionUID = -4056408501461794605L;

    @Column(name = "name")
    private String name;

    @Column(name = "discription")
    private String discription;

    @Column(name = "price_month")
    private int priceMonth;

    @Column(name = "price_single")
    private int priceSingle;

    @Column(name = "price_month_half")
    private int priceMonthHalf;


    @Column(name = "price_year")
    private int priceYear;

    @Column(name = "price_individual")
    private int priceIndividual;

    @Column(name = "price_other")
    private int priceOther;




    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerCard> cards = new HashSet<>();

//    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<User> users = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "group_id")
    private Group groups;

    public Price() {
        super();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(int priceMonth) {
        this.priceMonth = priceMonth;
    }

    public int getPriceMonthHalf() {
        return priceMonthHalf;
    }

    public void setPriceMonthHalf(int priceMonthHalf) {
        this.priceMonthHalf = priceMonthHalf;
    }

    public int getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(int priceSingle) {
        this.priceSingle = priceSingle;
    }

    public Set<CustomerCard> getCards() {
        return cards;
    }

    public void setCards(Set<CustomerCard> cards) {
        this.cards = cards;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroups() {
        return groups;
    }

    public void setGroups(Group groups) {
        this.groups = groups;
    }

    public int getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(int priceYear) {
        this.priceYear = priceYear;
    }

    public int getPriceIndividual() {
        return priceIndividual;
    }

    public void setPriceIndividual(int priceIndividual) {
        this.priceIndividual = priceIndividual;
    }

    public int getPriceOther() {
        return priceOther;
    }

    public void setPriceOther(int priceOther) {
        this.priceOther = priceOther;
    }

    //
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Price price = (Price) o;
//
//        if (priceMonth != price.priceMonth) return false;
//        if (priceSingle != price.priceSingle) return false;
//        if (priceMonthHalf != price.priceMonthHalf) return false;
//        if (name != null ? !name.equals(price.name) : price.name != null) return false;
//        if (discription != null ? !discription.equals(price.discription) : price.discription != null) return false;
//        if (cards != null ? !cards.equals(price.cards) : price.cards != null) return false;
//        return users != null ? users.equals(price.users) : price.users == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (discription != null ? discription.hashCode() : 0);
//        result = 31 * result + priceMonth;
//        result = 31 * result + priceSingle;
//        result = 31 * result + priceMonthHalf;
//        result = 31 * result + (cards != null ? cards.hashCode() : 0);
//        result = 31 * result + (users != null ? users.hashCode() : 0);
//        return result;
//    }
}
