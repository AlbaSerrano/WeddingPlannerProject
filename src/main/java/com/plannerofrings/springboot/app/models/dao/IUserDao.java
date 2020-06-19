package com.plannerofrings.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plannerofrings.springboot.app.models.entity.User;

//Repository to access to the data of the entity classes
@Repository
public interface IUserDao extends CrudRepository<User, Long> {

	// Query method name = @Query("select u from User where username=?1")
	public User findByUsername(String username);
}
