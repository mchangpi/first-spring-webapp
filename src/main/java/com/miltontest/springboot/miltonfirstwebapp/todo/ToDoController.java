package com.miltontest.springboot.miltonfirstwebapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
  
  private ToDoService toDoService;
  
  @Autowired
  public ToDoController(ToDoService toDoService) {
    super();
    this.toDoService = toDoService;
  }

  @RequestMapping("listtodos")
  public String listAllToDos(ModelMap model){
    List<ToDo> toDos = toDoService.findByUsername("miltontest");
    model.addAttribute("todos", toDos);
    return "listToDos";
  }

}
