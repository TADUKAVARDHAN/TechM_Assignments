package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection="positions")
public class PositionInfo {
	@Id
	private Integer id;
	@NotBlank
	@Size(max=240)
	private String posName;
	private String description;
	@CreatedDate
	@NotNull
	private Date createdAt=new Date();
}
