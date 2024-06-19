package com.ali.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SayHelloController
 */
@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHelloString(){
        return "Hello world ";
    }
    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First HTML Page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My First Html Page with body");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}