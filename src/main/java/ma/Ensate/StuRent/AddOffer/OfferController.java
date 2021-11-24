package ma.Ensate.StuRent.AddOffer;

import ma.Ensate.StuRent.AddOffer.Image.ImageRepository;
import ma.Ensate.StuRent.Mapper;
import ma.Ensate.StuRent.users.beans.Users;
import ma.Ensate.StuRent.users.ws.UsersWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Controller
public class OfferController {
    @Autowired

    private OfferRepository offerRepository;
    private ImageRepository imageRepository;
    public static boolean isLoggedOut = true;


    @GetMapping("/")
    public ModelAndView LoadAllOffers() {
        Iterable<Offer> offerList = offerRepository.findAll();
        offerList.forEach(Offer::ShowDetails);
        ModelAndView model = new ModelAndView("landing_page");

        model.addObject("offers", offerList);
        CheckSession(model);
        return model;
    }

    private void CheckSession(ModelAndView model) {
        model.addObject("isLoggedOut", isLoggedOut);
    }

    @GetMapping("/search")
    public ModelAndView DisplaySearchPage() {
        ModelAndView model = new ModelAndView("directory-listing-1");
        model.addObject("offerSearch", new OfferDTO());
        model.addObject("offers", offerRepository.findAll());
        CheckSession(model);
        return model;
    }
    @PostMapping("/search")
    public ModelAndView RunSearch(@RequestParam(value = "houseOptions", required = false) String[] houseOption, WebRequest request) {
        /*Offer searchOffer = Mapper.Map2Offer(offerDTO);*/

        String[] houseOptions = request.getParameterValues("houseOptions");
        String price = request.getParameter("price");
        Offer searchOffer = new Offer(
                request.getParameter("title"),
                request.getParameter("city"),
                Integer.parseInt(price ==  null || price.isEmpty() ? "0" : price),
                Contains(houseOptions, "wifi") ? "yes" : "no",
                Contains(houseOptions, "pets") ? "yes" : "no",
                Contains(houseOptions, "smoking") ? "yes" : "no"
        );

        List<Offer> targetOffers = FindTargetOffers(searchOffer);

        targetOffers.forEach(Offer::ShowDetails);

        ModelAndView model = new ModelAndView("directory-listing-1");
        model.addObject("offerSearch", new OfferDTO());
        model.addObject("offers", targetOffers);

        System.out.println("smoking: " + Arrays.toString(houseOptions));
        CheckSession(model);
        return model;
    }
    private boolean Contains(String[] array, String element){
        if (array == null) return false;

        for (String e : array) {
            if (e.compareToIgnoreCase(element) == 0) return true;
        }
        return false;
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
            } else
            if (!searchOffer.getCity().isEmpty()) {
                if (ThisOffer.getCity().compareToIgnoreCase(searchOffer.getCity()) == 0)
                    TargetOffersList.add(ThisOffer);
            } else
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
        model.addObject("offers", offerRepository.findAll());        //model.addObject("user", selectedUser.get());
        CheckSession(model);
        return model;
    }

    @GetMapping("/offer/add")
    public ModelAndView getOfferAdditionForm(WebRequest request) {
        System.out.println("test: "+ UsersWS.session);
        if(isLoggedOut){

            ModelAndView model = new ModelAndView("login");
            model.addObject("user", new Users());
            return model;
        }else{
            ModelAndView model = new ModelAndView("AddOffer");
            model.addObject("offer", new OfferDTO());
            CheckSession(model);
            return model;
        }
    }

    @PostMapping("/offer/confirm")
        public String getOfferAdditionSubmit(@ModelAttribute OfferDTO offerDTO, Model model) {

        Offer newOffer = Mapper.Map2Offer(offerDTO);
        offerRepository.save(newOffer);

        return "landing_page";
    }
}