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
                offerDTO.isHas_Wifi(),
                offerDTO.isAllow_Pets(),
                offerDTO.isAllow_Smoking()
        );
    }
}