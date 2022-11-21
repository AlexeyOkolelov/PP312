package com.pp312.springboot_312.dao;


import com.pp312.springboot_312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}
