package com.udemy.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //we wanted spring to manage this so we added @Controller annotation
public class SayHelloController {
	
	// whenever someone enters say-hello URL we return the following output
	
	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")  // map the URL of say-hello
	@ResponseBody        //it will return the given string as it is in the browser
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")  // map the URL of say-hello
	@ResponseBody        //it will return the given string as it is in the browser
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First Html Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("Glory Glory Man United");
		sb.append("</body>");
		sb.append("</html>");
        return sb.toString();
	}
	
	// sayHello.jsp
	// Jsp folder path: src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")  // map the URL of say-hello
	public String sayHelloJsp() {
		return "sayHello";
	}

}

