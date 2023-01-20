package com.miltontest.springboot.miltonfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

  @RequestMapping("hello")
  @ResponseBody
  public String sayHello() {
    return "Hello! Milton 1st Web App";
  }
  
  @RequestMapping("hellojsp")
  public String sayHelloHtml() {
    return "hellojsp";
  }
}
