package ma.Ensate.StuRent.AddOffer;

import ma.Ensate.StuRent.AddOffer.Image.ImageController;
import ma.Ensate.StuRent.AddOffer.Image.ImageRepository;
import ma.Ensate.StuRent.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class OfferController {
    @Autowired

    private OfferRepository offerRepository;
    private ImageRepository imageRepository;


    @GetMapping("/")
    public ModelAndView LoadAllOffers() {
        Iterable<Offer> offerList = offerRepository.findAll();
        offerList.forEach(Offer::ShowDetails);
        ModelAndView model = new ModelAndView("landing_page");

        model.addObject("offers", offerList);
        return model;
    }

    @GetMapping("/search")
    public ModelAndView DisplaySearchPage() {
        ModelAndView model = new ModelAndView("directory-listing-1");
        model.addObject("offerSearch", new OfferDTO());
        model.addObject("offers", offerRepository.findAll());
        return model;
    }

    @PostMapping("/search")
    public ModelAndView RunSearch(@ModelAttribute OfferDTO offerDTO) {
        Offer searchOffer = Mapper.Map2Offer(offerDTO);

        List<Offer> targetOffers = FindTargetOffers(searchOffer);
        targetOffers.forEach(Offer::ShowDetails);

        ModelAndView model = new ModelAndView("directory-listing-1");
        model.addObject("offerSearch", new OfferDTO());
        model.addObject("offers", targetOffers);
        return model;
    }

    private List<Offer> FindTargetOffers(Offer searchOffer) {
        List<Offer> TargetOffersList = new ArrayList<>();
        System.out.println("Search offer: " + searchOffer.ShowDetails());
        Iterable<Offer> offersList = offerRepository.findAll();
        System.out.println("All offers count: ");
        offersList.forEach(Offer::ShowDetails);

        offersList.forEach(ThisOffer -> {
            if (!searchOffer.getTitle().isEmpty()) {
                if (ThisOffer.getTitle().contains(searchOffer.getTitle()))
                    TargetOffersList.add(ThisOffer);
            }
            if (!searchOffer.getCity().isEmpty()) {
                if (ThisOffer.getCity().compareToIgnoreCase(searchOffer.getCity()) == 0)
                    TargetOffersList.add(ThisOffer);
            }
            if (!searchOffer.getAddress().isEmpty()) {
                if (ThisOffer.getAddress().compareToIgnoreCase(searchOffer.getAddress()) == 0)
                    TargetOffersList.add(ThisOffer);
            }
            if (!searchOffer.getGender().isEmpty()) {
                if (ThisOffer.getGender().compareToIgnoreCase(searchOffer.getGender()) == 0)
                    TargetOffersList.add(ThisOffer);
            }
            if (!searchOffer.getHas_Wifi().isEmpty()) {
                if (ThisOffer.getHas_Wifi().compareToIgnoreCase(searchOffer.getHas_Wifi()) == 0)
                    TargetOffersList.add(ThisOffer);
            }
            if (!searchOffer.getAllow_Pets().isEmpty()) {
                if (ThisOffer.getAllow_Pets().compareToIgnoreCase(searchOffer.getAllow_Pets()) == 0)
                    TargetOffersList.add(ThisOffer);
            }
            if (!searchOffer.getAllow_Smoking().isEmpty()) {
                if (ThisOffer.getAllow_Smoking().compareToIgnoreCase(searchOffer.getAllow_Smoking()) == 0)
                    TargetOffersList.add(ThisOffer);
            }
            if (searchOffer.getPrice() != 0) {
                if (ThisOffer.getPrice() <= searchOffer.getPrice())
                    TargetOffersList.add(ThisOffer);
            }
        });
/*
            if ((searchOffer.getTitle().isEmpty() && ThisOffer.getTitle().contains(searchOffer.getTitle())) ||
                    (searchOffer.getCity().isEmpty() && ThisOffer.getCity().compareToIgnoreCase(searchOffer.getCity()) == 0) ||
                    (searchOffer.getAddress().isEmpty() && ThisOffer.getAddress().compareToIgnoreCase(searchOffer.getAddress()) == 0) ||
                    (searchOffer.getGender().isEmpty() && ThisOffer.getGender().compareToIgnoreCase(searchOffer.getGender()) == 0) ||
                    (searchOffer.getHas_Wifi().isEmpty() && ThisOffer.getHas_Wifi().compareToIgnoreCase(searchOffer.getHas_Wifi()) == 0) ||
                    (searchOffer.getAllow_Pets().isEmpty() && ThisOffer.getAllow_Pets().compareToIgnoreCase(searchOffer.getAllow_Pets()) == 0) ||
                    (searchOffer.getAllow_Smoking().isEmpty() && ThisOffer.getAllow_Smoking().compareToIgnoreCase(searchOffer.getAllow_Smoking()) == 0) ||
                    (searchOffer.getPrice()!=0 && ThisOffer.getPrice() <= searchOffer.getPrice()))
            TargetOffersList.add(ThisOffer);
        });*/

        System.out.println("Finished Finding : " + TargetOffersList.size());
        return TargetOffersList;
    }

    @PostMapping("/offer/details")
    public ModelAndView LoadOfferInfo(WebRequest request) {
        //String post_ID = request.getParameter("post_id");
        Long post_ID = Long.parseLong(Objects.requireNonNull(request.getParameter("post_id")));
        String user_ID = Objects.requireNonNull(request.getParameter("user_id"));
        System.out.println("UserID: " + user_ID);


        //UsersWS userController = new UsersWS();
        //Optional<Users> selectedUser = userController.GetUserByID(user_ID);
        Optional<Offer> selectedOffer = offerRepository.findById(post_ID);


        if (selectedOffer.isEmpty()) {
            return new ModelAndView("error");
        }
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