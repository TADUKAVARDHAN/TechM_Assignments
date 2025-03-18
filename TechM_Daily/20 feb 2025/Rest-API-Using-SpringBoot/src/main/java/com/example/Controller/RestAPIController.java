package com.example.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.model.EmpDetails;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestAPIController {
	@GetMapping("/showA")
	public String showA() {
		return "A simple Rest API Application";
	}
	@GetMapping("/showB")
	public EmpDetails showB() {
		return new EmpDetails(1,"Bhanu Prakash",60000);
	}
	@GetMapping("/showC")
	public List<EmpDetails> showC() {
		return Arrays.asList(new EmpDetails(1,"Bhanu Prakash",60000),new EmpDetails(2,"Bhanu Prakash",60000),new EmpDetails(1,"Bhanu Prakash",60000));
	}
	@GetMapping("/showD")
    public Map<String,EmpDetails>showD(){
   	 Map<String,EmpDetails> map = new HashMap<>();
   	 map.put("e1", new EmpDetails(22,"Rajesh",80000.0));
   	 map.put("e2", new EmpDetails(24,"Kiran",60000.0));
   	 return map;
    }
    
    @GetMapping("/showE")
    public ResponseEntity<String>showE(){
   	 ResponseEntity<String> resp= new ResponseEntity<String>("Hello RE",HttpStatus.OK);
   	 return resp;
    }
}
