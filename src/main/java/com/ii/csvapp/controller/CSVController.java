package com.ii.csvapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ii.csvapp.entity.Users;
import com.ii.csvapp.entity.UsersRequest;
import com.ii.csvapp.service.CSVHelper;
import com.ii.csvapp.service.CSVService;

@RestController
@RequestMapping("/csv")
public class CSVController {
	@Autowired
	CSVService service;

	@PostMapping("/upload")
	public ResponseEntity<Boolean> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
		           List<Users> users = CSVHelper.csvToObject(file.getInputStream());
		           service.upload(users);
		           return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		      } catch (Exception e) {
		    	  System.out.println(e);
		    	  return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		      }
	}
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> addNewRecord(@RequestBody Users user){
		
		return new ResponseEntity<>(service.addUser(user), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Boolean> updateRecord(@RequestParam("id") int id, @RequestBody Users user){
		
		return new ResponseEntity<>(service.updateRecord(id, user), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRecord(@RequestParam("id") int id){
		
		return new ResponseEntity<>(service.deleteRecord(id), HttpStatus.OK);
	}
	
	@GetMapping("/retrieve")
	public ResponseEntity<List<Users>> getRecords(@RequestBody UsersRequest request){
		
		return new ResponseEntity<>(service.getRecords(request), HttpStatus.OK);
	}

}
