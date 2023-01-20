package com.miltontest.springboot.miltonfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

  @RequestMapping("sayhello")
  @ResponseBody //the object returned is automatically serialized into JSON
  public String sayHello() {
    return "Hello! Milton 1st Web App";
  }
  
  @RequestMapping("hello")
  public String hello() {
    return "hello";
  }
}
