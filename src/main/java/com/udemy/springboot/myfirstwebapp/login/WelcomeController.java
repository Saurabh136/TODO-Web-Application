package com.udemy.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
//	private AuthenticationService authenticationService;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	//private Logger logger = LoggerFactory.getLogger(getClass());
	//we would like to have a slash login URL
	//login => com.udemy.springboot.myfirstwebapp.login.LoginController => login.jsp
	
	//http://localhost:8080/login?=Saurabh
	//Model ( if we want anything to available to the view (i.e in .jsp file) , put it in the model)
	
	//GET 
	@RequestMapping(value="/", method = RequestMethod.GET)  // map the URL of login.jsp
	public String gotoWelcomePage(ModelMap model) {
		 model.put("name", getLoggedinUsername());
		//logger.debug("Request param is {}", name);
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
	
//	//POST
//	@RequestMapping(value="login", method = RequestMethod.POST)  // map the URL of login.jsp
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		if(authenticationService.authenticate(name,password)) {
//			
//		
//		model.put("name", name);
//		
//		return "welcome";
//		}
//		model.put("errorMessage", "Invalid Credentials! Please try again");
//		return "login";
//	}


