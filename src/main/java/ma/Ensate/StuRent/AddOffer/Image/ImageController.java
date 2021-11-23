package ma.Ensate.StuRent.AddOffer.Image;

import ma.Ensate.StuRent.AddOffer.OfferDTO;
import ma.Ensate.StuRent.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ImageController {
    @Autowired

    private ImageRepository imageRepository;
        
    public void SaveImages(@ModelAttribute OfferDTO offerDTO) {
        Image offerImage = Mapper.Map2Image(offerDTO);
        System.out.println("Is Null : " + offerImage == null);

        imageRepository.save(offerImage);
    }
}