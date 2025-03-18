package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
@Document
@Getter
@Setter
@ToString
public class EmpDetails {
	@Id
	private Integer id;
	private String name;
	private double sal;
}
