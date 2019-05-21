package bqtrung.demospring.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bqtrung.demospring.model.User;

@Repository
public interface DemoRepository extends JpaRepository<User, Integer> {
	@Query("SELECT e FROM User e")
	List<User> findAllUsers();
	
	@Query("SELECT e FROM User e WHERE e.id = ?1")
	User findByUserId(Integer id);
}
