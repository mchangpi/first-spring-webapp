package com.miltontest.springboot.miltonfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    model.addAttribute("toDos", toDos);
    return "listToDos";
  }

  @RequestMapping(value = "addToDo", method = RequestMethod.GET)
  public String newToDo(ModelMap model){
    ToDo toDo = new ToDo(0, (String) model.get("name"), "", LocalDate.now().plusMonths(1), false);
    model.put("toDo", toDo); //2-way binding, <form:form method = "post" modelAttribute = "toDo">
    return "addToDo";
  }

  @RequestMapping(value = "addToDo", method = RequestMethod.POST)
  public String addToDoPage(ModelMap model, ToDo toDo) {
    toDoService.addToDo((String) model.get("name"), 
        toDo.getDescription(), LocalDate.now().plusMonths(1), false);
    return "redirect:listtodos";
  }
}
