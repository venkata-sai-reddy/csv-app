package com.ii.csvapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ii.csvapp.entity.Users;
import com.ii.csvapp.entity.UsersRequest;
import com.ii.csvapp.repository.ICSVRepository;

@Service
public class CSVService {
	
	@Autowired
	ICSVRepository repo;

	public Boolean upload(List<Users> users) {
		
		List<Users> res = repo.saveAll(users);
		
		return res.size() == users.size();
	}

	public Boolean addUser(Users user) {
		Users res = repo.save(user);
		return res != null;
	}

	public Boolean updateRecord(int id, Users user) {
		if(repo.existsById(id)) {
			Users res = repo.save(user);
			return res!= null;
		}
		return false;
	}

	public Boolean deleteRecord(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Users> getRecords(UsersRequest request) {
		List<Users> users = repo.findAll();
		String firstName = request.getFirst_name() == null ? "":request.getFirst_name();
		String lastName = request.getLast_name() == null ? "":request.getLast_name();
		String role = request.getRole() == null ? "":request.getRole();
		int page = request.getPageNo() == 0 ? 1: request.getPageNo();
		int records = request.getPageRecords() == 0 ? 20: request.getPageRecords();
		users = users.stream().filter(user -> user.getFirst_name().contains(firstName) 
				&& user.getLast_name().contains(lastName)
				&& user.getRole().contains(role))
		.collect(Collectors.toList());
		
		if(page*records >= users.size()) {
			return users.subList(0, users.size());
		}
		return users.subList((page-1)*records, page*records);
	}
	
	
}
