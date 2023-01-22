package com.miltontest.springboot.miltonfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long>{
  public List<ToDo> findByUsername(String username);
}
