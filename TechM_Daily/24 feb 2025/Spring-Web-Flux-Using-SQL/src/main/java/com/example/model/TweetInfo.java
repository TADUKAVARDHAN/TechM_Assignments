package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tweet")
@Getter
@Setter
public class TweetInfo {
	@Id
	private Integer id;
	@NotBlank
	@Size(max=240)
	private String tweet;
	@CreatedDate
	@NotNull
	private Date createdAt=new Date();
}
