package com.Bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookstore.entity.myBookList;

@Repository
public interface myBookRepository extends JpaRepository<myBookList,Integer> {

}
