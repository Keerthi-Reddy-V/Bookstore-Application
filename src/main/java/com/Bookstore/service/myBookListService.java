package com.Bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Bookstore.entity.myBookList;
import com.Bookstore.repository.myBookRepository;

@Service
public class myBookListService {


  @Autowired
  private myBookRepository mybook;

  public void saveMyBooks(myBookList book){
    mybook.save(book);
}

public List<myBookList> getAllMybooks(){
  return mybook.findAll();
}

public void deleteById(int id){
  mybook.deleteById(id);
}

}
