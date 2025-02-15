package com.Bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="myBooks")
public class myBookList {

  @Id
  @Column(name="book_id")
  private int id;
  private String name;
  private String author;
  private Double price;
  public myBookList(int id, String name, String author, Double price) {
    super();
    this.id = id;
    this.name = name;
    this.author = author;
    this.price = price;
  }
  public myBookList(){
    super();
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAuthor() {
    return author;
  } 
  public void setAuthor(String author) {
    this.author = author;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  
}
