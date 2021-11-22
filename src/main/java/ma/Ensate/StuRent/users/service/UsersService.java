package ma.Ensate.StuRent.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.Ensate.StuRent.users.beans.Users;
import ma.Ensate.StuRent.users.dao.UsersDAO;

@Service
public class UsersService {

	@Autowired
	private UsersDAO usersDao;

	public Users findByUsername(String username) {
		return usersDao.findByUsername(username);
	}

	public int save(Users user) {
		String mail = user.getEmail();
		Optional<Users> us= findById(mail);
		if(us.isEmpty()) {
			usersDao.save(user);
			return 1;
		}else {
			return 0;
		}
		
	}

	public List<Users> findAll() {
		return usersDao.findAll();
	}

	public Optional<Users> findById(String id) {
		return usersDao.findById(id);
	}

	public void deleteById(String id) {
		usersDao.deleteById(id);
	}
	
	public int login (Users user) {
		Optional<Users> us = findById(user.getEmail());
		
		if(us.isEmpty()) {
			return 0;
		}else { 
			if(user.getPassword().equals(us.get().getPassword())) {
			  return 1;
			}else {
				return 0;
		}	
		}	
	}
	
	
}
