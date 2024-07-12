package com.soudeep.service;

import com.soudeep.beans.UserDetails;

public interface IUserService {
	public String insertUser(UserDetails user);
	public UserDetails loginUser(UserDetails user);
}
