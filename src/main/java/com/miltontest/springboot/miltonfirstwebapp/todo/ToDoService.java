package com.miltontest.springboot.miltonfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
  
  private static List<ToDo> toDos = new ArrayList<ToDo>();
  
  private static int toDosCount = 0; 
  
  static {
    toDos.add(new ToDo(++toDosCount, "miltontest", "Learn AWS", LocalDate.now().plusYears(1), false));
    toDos.add(new ToDo(++toDosCount, "miltontest", "Learn DevOps", LocalDate.now().plusYears(2), false));
    toDos.add(new ToDo(++toDosCount, "miltontest", "Learn DDD", LocalDate.now().plusYears(3), false));
  }

  public List<ToDo> findByUsername(String username){
    return toDos;
  }
  
  public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
    ToDo toDo = new ToDo(++toDosCount, username, description, targetDate, done);
    toDos.add(toDo);
  }
}
