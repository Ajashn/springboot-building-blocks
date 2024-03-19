package com.ajashn.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajashn.restservices.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);

}