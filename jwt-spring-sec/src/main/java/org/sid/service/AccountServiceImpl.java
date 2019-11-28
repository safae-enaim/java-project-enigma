package org.sid.service;

import org.sid.dao.UserRepository;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountService accountService;




	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}


@Override
public AppUser saveUser(AppUser user) {
	String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
	user.setPassword(hashPW);
	return userRepository.save(user);
}

}
