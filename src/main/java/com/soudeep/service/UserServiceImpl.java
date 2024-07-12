package com.soudeep.service;

import com.soudeep.beans.UserDetails;
import com.soudeep.factory.UserFactory;

public class UserServiceImpl implements IUserService {

	@Override
	public String insertUser(UserDetails user) {
		return UserFactory.getUserRepo().insertUser(user);
	}

	@Override
	public UserDetails loginUser(UserDetails user) {
		return UserFactory.getUserRepo().loginUser(user);
	}

}
