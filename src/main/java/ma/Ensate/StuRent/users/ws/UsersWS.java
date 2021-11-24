package ma.Ensate.StuRent.users.ws;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ma.Ensate.StuRent.AddOffer.OfferController;
import ma.Ensate.StuRent.users.beans.Users;
import ma.Ensate.StuRent.users.service.UsersService;
import ma.Ensate.StuRent.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class UsersWS {

	@Autowired
	private UsersService usersService;
	public static String session="";
	public static String msg="";
	public static String etatconnexion="";
	public HttpServletRequest sessionRequest;
	
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
	public String login(WebRequest request, Model model , HttpSession session) {
		model.addAttribute("user", new Users());
		System.out.println("model.getAttribute(	)");
		OfferController.isLoggedOut = false;
		return "login";
	}
	@PostMapping("/login")
	public String testconnexion(@ModelAttribute Users user, Model model ,HttpServletRequest request){
		sessionRequest = request;
		Users us = Mapper.Map2User(user);
		model.addAttribute("user", us.getUsername() + " & " + us.getPassword());
		/*System.out.println(us.getEmail());
		System.out.println(us.getPassword());
		System.out.println(us.getPhone()+"test");*/
		if(us.getPhone()==0) {
			int testlogin = usersService.login(us);
			if (testlogin == 1) {
				request.getSession().setAttribute("MY_SESSION_USERS", us.getEmail());
				session = (String) request.getSession().getAttribute("MY_SESSION_USERS");
				System.out.println(session);
				OfferController.isLoggedOut = false;
				return "landing_page";
			} else {
				//user = new Users();
				msg="failed authentification";
				OfferController.isLoggedOut = true;
				return "redirect:/login";
			}
		} else {
			int testmail= usersService.save(us);
			System.out.println(testmail);
			if (testmail==1){
				return "landing_page";
			}else{
				msg="failed authentification";
				OfferController.isLoggedOut = true;
				return "redirect:/login";
			}
		}
		}


	@PostMapping("/signup")
	public int save(@RequestBody Users users) {
		OfferController.isLoggedOut = false;
		return usersService.save(users);
	}
	@GetMapping("/destroy")
	public ModelAndView destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		OfferController.isLoggedOut = true;

		ModelAndView model = new ModelAndView("landing_page");
		sessionRequest = request;
		model.addObject("isLoggedOut", OfferController.isLoggedOut);
		System.out.println("----------------------> Session : " + request.getSession(false) == null);

		return model;
	}

}