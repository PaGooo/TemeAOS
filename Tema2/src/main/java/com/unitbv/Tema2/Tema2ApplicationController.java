package com.unitbv.Tema2;

import java.util.List;

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

	PersonDAO personDao = EntityDAOImplFactory.createNewPersonDAOImpl("testPU");

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
			Person p = new Person(name, email);
			personDao.createOrUpdate(p);
			return "Inserted " + name + ";" + email;
		} catch (Exception e) {
			return "Failed";
		}
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll() {
		try {
			List<Person> persons = personDao.readAll();
			return persons.toString();
		} catch (Exception e) {
			return "Failed";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("id") int id, @RequestParam("newEmail") String newEmail) {
		try {
			Person p = personDao.findById(id);
			p.setEmail(newEmail);
			personDao.update(p);
			return "Updated " + p.getName();
		} catch (Exception e) {
			return "Failed";
		}
	}
	
	public String delete(@RequestParam("id") int id) {
		try {
			Person p = personDao.findById(id);
			personDao.delete(p);
			return "Deleted " + p.getName();
		} catch (Exception e) {
			return "Failed";
		}
	}
}
