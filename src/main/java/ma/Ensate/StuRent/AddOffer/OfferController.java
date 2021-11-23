package ma.ensate.sturent.AddOffer;

import ma.ensate.sturent.AddOffer.Image.ImageController;
import ma.ensate.sturent.AddOffer.Image.ImageRepository;
import ma.ensate.sturent.Mapper;
import ma.ensate.sturent.users.beans.Users;
import ma.ensate.sturent.users.ws.UsersWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class OfferController {
    @Autowired

    private OfferRepository offerRepository;
    private ImageRepository imageRepository;


    @GetMapping("/")
    public ModelAndView LoadAllOffers(){
        Iterable<Offer> offerList = offerRepository.findAll();
        offerList.forEach(Offer::ShowDetails);
        ModelAndView model = new ModelAndView("landing_page");

        model.addObject("offers", offerList);
        return model;
    }

    @PostMapping("/offer/details")
    public ModelAndView LoadOfferInfo(WebRequest request){
        //String post_ID = request.getParameter("post_id");
        Long post_ID = Long.parseLong(Objects.requireNonNull(request.getParameter("post_id")));
        String user_ID = Objects.requireNonNull(request.getParameter("user_id"));
        System.out.println("UserID: " + user_ID);


        //UsersWS userController = new UsersWS();
        //Optional<Users> selectedUser = userController.GetUserByID(user_ID);
        Optional<Offer> selectedOffer = offerRepository.findById(post_ID);


        if (selectedOffer.isEmpty()){ return new ModelAndView("error");}
        //if (selectedUser.isEmpty()){ return new ModelAndView("error");}

        ModelAndView model = new ModelAndView("directory-details-1");
        model.addObject("offer", selectedOffer.get());
        //model.addObject("user", selectedUser.get());
        return model;
    }

    @GetMapping("/offer/add")
    public String getOfferAdditionForm(WebRequest request, Model model) {
        model.addAttribute("offer", new OfferDTO());
        return "AddOffer";
    }

    @PostMapping("/offer/confirm")
    public String getOfferAdditionSubmit(@ModelAttribute OfferDTO offerDTO, Model model) {
        Offer newOffer = Mapper.Map2Offer(offerDTO);
        System.out.println(newOffer.ShowDetails());

        offerRepository.save(newOffer);

        ImageController imageController = new ImageController();
        return "landing_page";
    }
}