package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection="person")
@Getter
@Setter
@AllArgsConstructor
public class PersonInfo {
	@Id
	private Integer id;
	private String FirstName;
	private String Lastname;
	private int age;
	private Sex sex;
	private String intrests;
}
