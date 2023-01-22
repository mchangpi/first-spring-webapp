package com.miltontest.springboot.miltonfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcomePage(ModelMap model) {
    model.put("name", "milton");
    return "welcome";
  }  
  
  /*
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
    if(authService.authenticate(name, password)) {
      model.put("name", name);
      model.put("password", password);

      return "welcome";
    }

    logger.debug("{} login failed", name);
    model.put("errorMessage", "Invalid Credentials for " + name + ", please try again");
    return "login";
  }

  @RequestMapping("login")
  public String logInPage(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    logger.debug("Rquest param is {}", name);
    //System.out.println("Request param is " + name); // NOT for production use
    return "login";
  }
  */
}

