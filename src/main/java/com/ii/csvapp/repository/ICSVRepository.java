package com.ii.csvapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ii.csvapp.entity.Users;

@Repository
public interface ICSVRepository extends JpaRepository<Users, Integer>{

	
}
