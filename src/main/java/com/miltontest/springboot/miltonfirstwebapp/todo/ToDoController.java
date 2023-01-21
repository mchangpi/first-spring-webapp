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
  public String newToDo(){
    return "addToDo";
  }

  @RequestMapping(value = "addToDo", method = RequestMethod.POST)
  public String addToDoPage(@RequestParam String description, ModelMap model) {
    toDoService.addToDo((String) model.get("name"), 
        description, LocalDate.now().plusYears(1), false);
    return "redirect:listtodos";
  }
}
