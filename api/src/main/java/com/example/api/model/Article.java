package com.example.api.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "articles")


public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column()
    private String nom;

    @Column()
    private Integer price;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public Article(Integer id, String nom, Integer price, String image) {
        this.id = id;
        this.nom = nom;
        this.price = price;
        this.image = image;
    }

    public Article() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

  /*  public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    } */
}
