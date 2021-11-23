package ma.ensate.sturent;

import ma.ensate.sturent.AddOffer.Image.Image;
import ma.ensate.sturent.AddOffer.Offer;
import ma.ensate.sturent.AddOffer.OfferDTO;
import ma.ensate.sturent.users.beans.Users;

public class Mapper {
    static public Offer Map2Offer(OfferDTO offerDTO) {
        return new Offer(
                0L,
                offerDTO.getTitle(),
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

    static public Users Map2User(Users user) {
        return new Users(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getGender(),
                user.getPhone(),
                user.isAdmin()
        );
    }

    public static Image Map2Image(OfferDTO offerDTO) {
        String ImagesFiles = offerDTO.getImages();

        System.out.println("Path is: " + ImagesFiles);
        System.out.println("PostID is: " + offerDTO.getPost_ID());
        return new Image(
                offerDTO.getPost_ID(),
                "test");
    }
}
