package com.nttdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Controller
public class RestexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestexampleApplication.class, args);
	}

	@RequestMapping("/")
	protected String swagger() {
		return "redirect:swagger-ui.html";
	}
}
