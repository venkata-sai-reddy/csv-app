package com.ii.csvapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ii.csvapp.entity.Users;
import com.ii.csvapp.repository.ICSVRepository;

@Service
public class CSVService {
	
	@Autowired
	ICSVRepository repo;

	public Boolean upload(List<Users> users) {
		
		List<Users> res = repo.saveAll(users);
		
		return res.size() == users.size();
	}
	
	
}
