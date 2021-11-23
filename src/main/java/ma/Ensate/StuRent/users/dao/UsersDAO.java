package ma.ensate.sturent.users.dao;

import ma.ensate.sturent.users.beans.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<Users, String>{

	Users findByUsername(String username);
	
}
