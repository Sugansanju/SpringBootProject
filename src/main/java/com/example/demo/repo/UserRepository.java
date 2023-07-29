package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	@Query(value="select * from users where username=?1 and password=?2",nativeQuery=true)
	User checkUser(String userName, String password);

}
