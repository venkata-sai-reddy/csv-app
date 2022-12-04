package com.ii.csvapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ii.csvapp.entity.Users;
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
		           List<Users> users = CSVHelper.csvToTutorials(file.getInputStream());
		           service.upload(users);
		           return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		      } catch (Exception e) {
		    	  System.out.println(e);
		    	  return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		      }
	}
	
	

}
