package org.sid.service;

import org.sid.entities.AppUser;

public interface AccountService {

	public AppUser saveUser(AppUser user);
	public AppUser findUserByUsername(String username);
}
