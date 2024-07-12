package com.soudeep.factory;

import com.soudeep.repository.IUserRepo;
import com.soudeep.repository.UserRepoImpl;
import com.soudeep.service.IUserService;
import com.soudeep.service.UserServiceImpl;

public class UserFactory {
	private static UserRepoImpl userRepo = null;
	private static UserServiceImpl userService = null;
	
	private UserFactory() {}
	
	public static IUserRepo getUserRepo() {
		if (userRepo == null) {
			userRepo = new UserRepoImpl();
		}
		return userRepo;
	}
	
	public static IUserService getUserService() {
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
}
