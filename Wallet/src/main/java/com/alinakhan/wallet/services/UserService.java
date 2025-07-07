package com.alinakhan.wallet.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.alinakhan.wallet.config.exception.UserServiceException;
import com.alinakhan.wallet.model.dto.UserDetails;
import com.alinakhan.wallet.model.entity.User;

@Component
public interface UserService extends UserDetailsService {

	public UserDetails createUserProfile(UserDetails useProfile) throws UserServiceException;
	public UserDetails updateUserProfile(UserDetails useProfile) throws UserServiceException;
	public void deleteUserProfileByUserName(String userName) throws UserServiceException;
	public UserDetails getUserProfileByUserName(String userName) throws UserServiceException;
	public List<UserDetails> getAllUserProfile() throws UserServiceException;
	public UserDetails createSignUp(User user) throws UserServiceException;
	public User getUserDbEntityByUserName(String userName) throws UserServiceException;
}
