package com.program.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.program.entity.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {
}