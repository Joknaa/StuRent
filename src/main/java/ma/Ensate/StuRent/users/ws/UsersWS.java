package ma.Ensate.StuRent.users.ws;


import ma.Ensate.StuRent.users.beans.Users;
import ma.Ensate.StuRent.users.service.UsersService;
import ma.ensate.sturent.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class UsersWS {

	@Autowired
	private UsersService usersService;

	
	public Users findByUsername(String username) {
		return usersService.findByUsername(username);
	}



	public Optional<Users> findById(String id) {
		return usersService.findById(id);
	}

	@DeleteMapping("admin/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		usersService.deleteById(id);
	}

	@GetMapping("/login")
	public String login(WebRequest request, Model model) {
		model.addAttribute("user", new Users());
		System.out.println("model.getAttribute(	)");
		return "login";
	}
	@PostMapping("/login")
	public String testconnexion(@ModelAttribute Users user, Model model){
		Users us = Mapper.Map2User(user);
		model.addAttribute("user", us.getUsername() + " & " + us.getPassword());
		System.out.println(us.getEmail());
		System.out.println(us.getPassword());
		System.out.println(us.getPhone()+"test");
		int testlogin= usersService.login(us);
		   if (testlogin==1){
		       return "landing_page";
		   }else {
			   //user = new Users();
			   return "redirect:/login";
		   }
		}


	@PostMapping("/signup")
	public int save(@RequestBody Users users) {
		return usersService.save(users);
	}


	
	
	
}
