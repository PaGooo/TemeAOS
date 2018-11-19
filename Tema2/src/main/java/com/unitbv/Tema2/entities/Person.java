package com.unitbv.Tema2.entities;

import javax.persistence.*;

@Entity
@Table(name = "\"Person\"")
public class Person implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// properties
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;

	// constructors
	public Person() {
	}

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
