package com.soudeep.repository;

import com.soudeep.beans.UserDetails;

public interface IUserRepo {
	public String insertUser(UserDetails user);
	public UserDetails loginUser(UserDetails user);
}
