package com.program.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.program.dao.IUserDAO;
import com.program.dao.repository.UserRepository;
import com.program.entity.User;


@Repository("userDao")
@Transactional
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Find By Username
	 * 
	 * @param userName
	 * @return Optional<User>
	 */
	@Override
	public Optional<User> findByUsername(String userName) {
		return userRepository.findById(userName);
	}
}