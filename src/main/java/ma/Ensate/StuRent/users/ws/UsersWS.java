package ma.ensate.sturent.users.ws;

import ma.ensate.sturent.Mapper;
import ma.ensate.sturent.users.beans.Users;
import ma.ensate.sturent.users.service.UsersService;
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
    public String testconnexion(@ModelAttribute Users user, Model model) {
        Users us = Mapper.Map2User(user);
        model.addAttribute("user", us.getUsername() + " & " + us.getPassword());
        System.out.println(us.getEmail());
        System.out.println(us.getPassword());
        System.out.println(us.getPhone() + "test");
        if (us.getPhone() == 0) {
            int testlogin = usersService.login(us);
            if (testlogin == 1) {
                return "landing_page";
            } else {
                //user = new Users();
                return "redirect:/login";
            }
        } else {
            int testmail = usersService.save(us);
            System.out.println(testmail);
            if (testmail == 1) {
                return "landing_page";
            } else {
                return "redirect:/login";
            }
        }
    }

    @PostMapping("/signup")
    public int save(@RequestBody Users users) {
        return usersService.save(users);
    }



    public Optional<Users> GetUserByID(String user_Name) {
        return usersService.findById(user_Name);
    }
}
