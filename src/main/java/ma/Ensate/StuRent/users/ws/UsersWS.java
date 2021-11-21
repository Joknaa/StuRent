package ma.Ensate.StuRent.users.ws;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.Ensate.StuRent.users.beans.Users;
import ma.Ensate.StuRent.users.service.UsersService;

@Controller
@RequestMapping("users")
public class UsersWS {

	@Autowired
	private UsersService usersService;

	
	public Users findByUsername(String username) {
		return usersService.findByUsername(username);
	}

	@PostMapping("/signup")
	public int save(@RequestBody Users users) {
		return usersService.save(users);
	}

	public Optional<Users> findById(String id) {
		return usersService.findById(id);
	}

	@DeleteMapping("admin/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		usersService.deleteById(id);
	}

	@GetMapping("/login")
	public String login(@RequestParam(required = false) String user) {
		System.out.print(user);
		//System.out.print(password);
		Users us = new Users();
		us.setUsername(user);
		us.setPassword("134553");
		int login =usersService.login(us);
		System.out.print(login);
		return "login";
	}
	
	
	
	
}
