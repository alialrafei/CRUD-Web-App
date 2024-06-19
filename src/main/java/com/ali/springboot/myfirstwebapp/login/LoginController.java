package com.ali.springboot.myfirstwebapp.login;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.slf4j.Logger;
@Controller
@SessionAttributes("name")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

  
    
    private AuthenticationService authenticationService;
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    // public String gotoLoginPage(@RequestParam String name,ModelMap model){
    //     model.put("name", name);
    //     logger.info("Request param is {}",name);
    //    // System.out.println("Request param is "+name);//not recommended in production code
    //     return "login";
    // }
    //handling get request to return login model to the servlet dispatcher to return login jsp view
    @RequestMapping(value = "login",method = RequestMethod.GET )
    public String gotoLoginPage(){
        
       
        return "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST )
    public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model){
        
        // to send these paramters to welcome page we need to add them to model map
        if(authenticationService.authenticate(name, password)){
            model.put("name", name);
            model.put("password", password);
            return "welcomepage";
        }
        model.put("errorMessage", "Invalid Credentials! Please Try again.");
        return "login";
    }
}
