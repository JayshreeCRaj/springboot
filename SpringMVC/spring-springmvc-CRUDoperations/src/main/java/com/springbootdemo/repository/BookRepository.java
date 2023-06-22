package com.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.entities.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

}
