package org.bhanu;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class Runner implements CommandLineRunner{
	@Override
	public void run(String ...args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		System.out.println(Arrays.asList(args));
	}
}
