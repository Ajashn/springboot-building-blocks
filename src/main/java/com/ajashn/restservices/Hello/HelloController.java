package com.ajashn.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	//@GetMapping("/helloworld1")
		@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
		public String helloWorld() {
			return "Hello World1";
		}
		
		@GetMapping("/helloworld-bean")
		public UserDetails helloWorldBean() {
			return new UserDetails("ajas", "jashn", "Hyderabad");
		}
		
}
