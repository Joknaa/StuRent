package ma.Ensate.StuRent.AddOffer;

import javax.persistence.*;

@Entity(name = "post") // This tells Hibernate to make a table out of this class
@Table(name = "post")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Post_ID;
    private String User_Name;
    private String Title;
    private String City;
    private String Address;
    private String Description;
    private String Gender;
    private int Price;
    private String Has_Wifi;
    private String Allow_Pets;
    private String Allow_Smoking;
    private String Phone;
    private String Images;

    public Offer() { }
    public Offer(String user_Name, String title, String city, String address, String description, int price, String gender, String has_wifi, String allow_pets, String allow_smoking, String phone) {
        setPostID(0L);
        setUserID(user_Name);
        setTitle(title);
        setCity(city);
        setAddress(address);
        setDescription(description);
        setPrice(price);
        setGender(gender);
        setHas_Wifi(has_wifi);
        setAllow_Pets(allow_pets);
        setAllow_Smoking(allow_smoking);
        setPhone(phone);
    }
    public Offer(String title, String city, int price, String gender, String has_wifi, String allow_pets, String allow_smoking, String phone) {
        setPostID(0L);
        setTitle(title);
        setCity(city);
        setPrice(price);
        setGender(gender);
        setHas_Wifi(has_wifi);
        setAllow_Pets(allow_pets);
        setAllow_Smoking(allow_smoking);
        setPhone(phone);
    }
    public Offer(String title, String city, int price, String has_wifi, String allow_pets, String allow_smoking) {
        setTitle(title);
        setCity(city);
        setPrice(price);
        setHas_Wifi(has_wifi);
        setAllow_Pets(allow_pets);
        setAllow_Smoking(allow_smoking);
    }


    public Long getPostID(){return this.Post_ID;}
    public String getUserID(){return this.User_Name;}
    public String getAddress(){return this.Address;}
    public String getCity(){return this.City;}
    public String getDescription(){return this.Description;}
    public String getGender(){return this.Gender;}
    public int getPrice(){return this.Price;}

    public void setPostID(Long ID){this.Post_ID = ID;}
    public void setUserID(String ID){this.User_Name = ID;}
    public void setCity(String city){this.City = city;}
    public void setAddress(String address){this.Address = address;}
    public void setDescription(String max){this.Description = max;}
    public void setGender(String gender){this.Gender = gender;}
    public void setPrice(int price){this.Price = price;}

    public String getHas_Wifi() {
        return Has_Wifi;
    }
    public void setHas_Wifi(String has_Wifi) {
        Has_Wifi = has_Wifi;
    }
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String ShowDetails() {
        return String.format("%s | %s | %s | %d | %s | %s | %s | %s", City, Address, Description, Price, Gender, Has_Wifi, Allow_Pets, Allow_Smoking);
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }
}
