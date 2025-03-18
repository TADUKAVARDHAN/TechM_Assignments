package com.example.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataSequence {
	@Id
	private String id;
	private long seq;
}
