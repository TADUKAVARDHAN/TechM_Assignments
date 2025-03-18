package org.bhanu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CommandRunner implements CommandLineRunner{
	@Value("${my.code.id}")
	private int id;
	@Value("${my.code.name}")
	private String name;
	@Value("${my.code.mdn.object}")
	private String object;
	@Value("${my.code.mdn.type}")
	private String type;
	@Value("${my.code.mdn.sale}")
	private String sale;
	@Value("${my.code.mdn.str.service}")
	private String service;
	@Override
	public String toString() {
		return "CommandLineRunner[ID:"+id+", Name:"+name+", Object:"+object+", type:"+type+", Sale:"+sale+", Service:"+service+"]"; 
	}
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this);
	}
}

