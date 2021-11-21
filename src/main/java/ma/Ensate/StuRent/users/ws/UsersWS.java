package ma.Ensate.StuRent.users.ws;

import ma.Ensate.StuRent.users.beans.Users;
import ma.Ensate.StuRent.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
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

		return "login";
	}
	@GetMapping("/")
	public String home_page() {

		return "landing_page";
	}
	
	
	
	
}
