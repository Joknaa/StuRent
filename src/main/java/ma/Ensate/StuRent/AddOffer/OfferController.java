package ma.ensate.sturent.AddOffer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/offer")
public class OfferController {

    @GetMapping("/add")
    public String offerForm(Model model) {
        model.addAttribute("offer", new Offer());
        return "AddOffer_OLD";
    }

    @PostMapping("/Add")
    public String offerSubmit(@ModelAttribute Offer offer, Model model) {
        model.addAttribute("offer", offer);
        AddOfferToDatabase(offer);

        return "AddOffer_Result";
    }

    private void AddOfferToDatabase(Offer offer){

    }

}
