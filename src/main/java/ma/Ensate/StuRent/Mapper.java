package ma.Ensate.StuRent;

import ma.Ensate.StuRent.AddOffer.Image.Image;
import ma.Ensate.StuRent.AddOffer.Offer;
import ma.Ensate.StuRent.AddOffer.OfferDTO;
import ma.Ensate.StuRent.users.beans.Users;

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

    public static Offer MapSearch(OfferDTO offerDTO){
        return new Offer(
                offerDTO.getTitle(),
                offerDTO.getCity(),
                offerDTO.getPrice(),
                offerDTO.isCheckBox_Female() ? "Woman" : "Man",
                offerDTO.isCheckBox_wifi() ? "yes" : "no",
                offerDTO.isCheckBox_pets() ? "yes" : "no",
                offerDTO.isCheckBox_smoking() ? "yes" : "no"
        );
    }
}
