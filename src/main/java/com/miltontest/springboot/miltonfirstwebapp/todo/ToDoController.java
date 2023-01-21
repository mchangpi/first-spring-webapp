package com.miltontest.springboot.miltonfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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

  @RequestMapping(value = "addtodo", method = RequestMethod.GET)
  public String newToDo(ModelMap model){
    ToDo toDo = new ToDo(0, (String) model.get("name"), "", LocalDate.now().plusMonths(1), false);
    model.put("toDo", toDo); //2-way binding, <form:form method = "post" modelAttribute = "toDo">
    return "addToDo";
  }

  @RequestMapping(value = "addtodo", method = RequestMethod.POST)
  public String addToDoPage(ModelMap model, @Valid ToDo doDo, BindingResult result) {
    
    if(result.hasErrors()) {
      return "addToDo";
    }
    
    toDoService.addToDo((String) model.get("name"), 
        doDo.getDescription(), LocalDate.now().plusMonths(1), false);
    return "redirect:listtodos";
  }

  @RequestMapping("deletetodo")
  public String deleteToDo(@RequestParam int id){
    toDoService.deleteById(id);
    return "redirect:listtodos";
  }
}
