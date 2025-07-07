package com.alinakhan.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alinakhan.wallet.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserName(String userName);
}
