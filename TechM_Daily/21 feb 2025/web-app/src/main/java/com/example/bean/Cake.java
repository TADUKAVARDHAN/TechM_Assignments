package com.example.bean;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Cake {
	@NotNull(message = "Must select one Option")
	private Integer selectedcake;
	private String flavor;
	private Integer flavorRate;
	private Integer includeCandles=0;
	private Integer includeinscription=0;
	private String theinscription;
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "Address is required")
	private String address;
	@NotEmpty(message = "Phone number is required")
	@Pattern(regexp = "^[\\d]{10}$", message = "Phone number should be 10 digits")
	private String phonenumber;
	private double price;
}
