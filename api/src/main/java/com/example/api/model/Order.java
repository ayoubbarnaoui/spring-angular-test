package com.example.api.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;

    private String Ref;

    @OneToMany
    @JoinColumn(name = "Article_id")
    private List<Article> products;

    public Order() {
    }

    public Order(int id, Date date, String ref, List<Article> products) {
        this.id = id;
        this.date = date;
        Ref = ref;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }

    public List<Article> getProducts() {
        return products;
    }

    public void setProducts(List<Article> products) {
        this.products = products;
    }
}
