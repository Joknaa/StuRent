package ma.ensate.sturent;

import ma.ensate.sturent.AddOffer.Offer;
import ma.ensate.sturent.AddOffer.OfferDTO;

public class Mapper {
    static public Offer Map2Offer(OfferDTO offerDTO){
        return new Offer(
                0L,
                offerDTO.getCity(),
                offerDTO.getAddress(),
                offerDTO.getDescription(),
                offerDTO.getPrice(),
                offerDTO.getGender(),
                offerDTO.getHas_Wifi(),
                offerDTO.getAllow_Pets(),
                offerDTO.getAllow_Smoking()
        );
    }
}