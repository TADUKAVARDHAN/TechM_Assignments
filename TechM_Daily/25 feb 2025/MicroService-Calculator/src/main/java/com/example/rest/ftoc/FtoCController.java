package com.example.rest.ftoc;


import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FtoCController {
	protected Logger l=Logger.getLogger(FtoCController.class.getName());
	@RequestMapping("/FtoC")
	public String FtoCConverter(@RequestParam(defaultValue="0") String temp) {
		float f=Float.valueOf(temp);
		return Float.toString((f-32)*5/9);
	}
}
