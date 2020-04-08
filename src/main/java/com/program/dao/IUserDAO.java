package com.program.dao;

import java.util.Optional;

import com.program.entity.User;


public interface IUserDAO {


	Optional<User> findByUsername(String username);
}