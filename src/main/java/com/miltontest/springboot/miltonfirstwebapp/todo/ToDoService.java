package com.miltontest.springboot.miltonfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
  private static List<ToDo> todos = new ArrayList<>();
  static {
    todos.add(new ToDo(1, "miltontest", "Learn AWS", LocalDate.now().plusYears(1), false));
    todos.add(new ToDo(2, "miltontest", "Learn DevOps", LocalDate.now().plusYears(2), false));
    todos.add(new ToDo(3, "miltontest", "Learn DDD", LocalDate.now().plusYears(3), false));
  }

  public List<ToDo> findByUsername(String username){
    return todos;
  }
}
