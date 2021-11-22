package ma.ensate.sturent.AddOffer.Image;

import ma.ensate.sturent.AddOffer.Image.Image;
import ma.ensate.sturent.AddOffer.Image.ImageRepository;
import ma.ensate.sturent.AddOffer.OfferDTO;
import ma.ensate.sturent.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

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