package ma.Ensate.StuRent.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.Ensate.StuRent.users.beans.Users;
@Repository
public interface UsersDAO extends JpaRepository<Users, String>{

	Users findByUsername(String username);
	
}
