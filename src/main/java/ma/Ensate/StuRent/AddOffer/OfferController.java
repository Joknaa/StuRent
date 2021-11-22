package ma.ensate.sturent.AddOffer;

import ma.ensate.sturent.AddOffer.Image.Image;
import ma.ensate.sturent.AddOffer.Image.ImageController;
import ma.ensate.sturent.AddOffer.Image.ImageRepository;
import ma.ensate.sturent.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OfferController {
    @Autowired

    private OfferRepository offerRepository;
    private ImageRepository imageRepository;

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

    @GetMapping("/")
    public ModelAndView LoadAllOffers(){
        Iterable<Offer> offerList = offerRepository.findAll();
        offerList.forEach(Offer::ShowDetails);
        ModelAndView model = new ModelAndView("landing_page");

        model.addObject("offers", offerList);
        return model;
    }



}