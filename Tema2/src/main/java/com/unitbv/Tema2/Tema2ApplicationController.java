package com.unitbv.Tema2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unitbv.Tema2.dao.PersonDAO;
import com.unitbv.Tema2.entities.Person;
import com.unitbv.Tema2.util.EntityDAOImplFactory;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Tema2ApplicationController {

	public static void main(String[] args) {
		SpringApplication.run(Tema2ApplicationController.class, args);
	}

	@RequestMapping("/")
	public String greeting() {
		return "Hello World";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name) {
		return "Hello " + name;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@RequestParam("name") String name, @RequestParam("email") String email) {
		try {
			PersonDAO personDao = EntityDAOImplFactory.createNewPersonDAOImpl("testPU");
			try {
				Person p = new Person(name, email);
				personDao.createOrUpdate(p);
			} finally {
				personDao.close();
			}
			return "Inserted " + name + ";" + email;
		} catch (Exception e) {
			return "Failed";
		}
	}
}
