package ma.ensate.sturent.AddOffer;

import ma.ensate.sturent.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(path = "/offer")
public class OfferController {
    @Autowired
    private OfferRepository offerRepository;

    @GetMapping("/add")
    public String getOfferAdditionForm(WebRequest request, Model model) {
        model.addAttribute("offer", new OfferDTO());
        return "AddOffer";
    }

    @PostMapping("/confirm")
    public String getOfferAdditionSubmit(@ModelAttribute OfferDTO offerDTO, Model model) {
        Offer newOffer = Mapper.Map2Offer(offerDTO);
        System.out.println(newOffer.ShowDetails());
        offerRepository.save(newOffer);

        //model.addAttribute("offer", newOffer.ShowDetails());
        //System.out.println(newOffer.ShowDetails());
        return "directory-listing-1";
    }
    /*
    @GetMapping("/Confirm")
    public String getOfferAdditionSubmit(@RequestParam Map<String, String> params, Model model) {

        Offer newOffer = new Offer(
                params.get("city"),
                params.get("address"),
                params.get("description"),
                Integer.parseInt(params.get("price")),
                params.get("gender"));

        AddOfferToDatabase(newOffer);

        model.addAttribute("offer", newOffer.ShowDetails());
        System.out.println(newOffer.ShowDetails());
        return "AddOfferConfirmation";
    }*/

    private void AddOfferToDatabase(Offer offer){

    }
}