package ma.ensate.sturent.AddOffer;

import com.sun.istack.NotNull;

public class OfferDTO {
    @NotNull
    private Long Post_ID;
    @NotNull
    private Long User_ID;
    @NotNull
    private String City;
    private String Address;
    @NotNull
    private String Gender;
    private String Description;
    @NotNull
    private int Price;

    private String Has_Wifi;
    private String Allow_Pets;
    private String Allow_Smoking;

    public String getAllow_Pets() {
        return Allow_Pets;
    }

    public void setAllow_Pets(String allow_Pets) {
        Allow_Pets = allow_Pets;
    }

    public String getAllow_Smoking() {
        return Allow_Smoking;
    }

    public void setAllow_Smoking(String allow_Smoking) {
        Allow_Smoking = allow_Smoking;
    }


    public String getHas_Wifi() {
        return Has_Wifi;
    }

    public void setHas_Wifi(String has_Wifi) {
        Has_Wifi = has_Wifi;
    }




    public Long getPost_ID() {
        return Post_ID;
    }

    public void setPost_ID(Long post_ID) {
        Post_ID = post_ID;
    }

    public Long getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(Long user_ID) {
        User_ID = user_ID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
