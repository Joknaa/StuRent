package ma.Ensate.StuRent.users.dao;

import ma.Ensate.StuRent.users.beans.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<Users, String>{

	Users findByUsername(String username);
	
}
