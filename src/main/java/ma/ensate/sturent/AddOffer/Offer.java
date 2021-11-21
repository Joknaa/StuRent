package ma.ensate.sturent.AddOffer;

import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "post") // This tells Hibernate to make a table out of this class
@Table(name = "post")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Post_ID;
    private Long User_ID;
    private String City;
    private String Address;
    private String Description;
    private String Gender;
    private int Price;
    private String Has_Wifi;
    private String Allow_Pets;
    private String Allow_Smoking;

    public Offer() { }
    public Offer(Long user_ID, String city, String address, String description, int price, String gender, String has_wifi, String allow_pets, String allow_smoking) {
        setPostID(0L);
        setUserID(user_ID);
        setCity(city);
        setAddress(address);
        setDescription(description);
        setPrice(price);
        setGender(gender);
        setHas_Wifi(has_wifi);
        setAllow_Pets(allow_pets);
        setAllow_Smoking(allow_smoking);
    }


    public Long getPostID(){return this.Post_ID;}
    public Long getUserD(){return this.User_ID;}
    public String getAddress(){return this.Address;}
    public String getDescription(){return this.Description;}
    public String getGender(){return this.Gender;}
    public int getPrice(){return this.Price;}

    public void setPostID(Long ID){this.Post_ID = ID;}
    public void setUserID(Long ID){this.User_ID = ID;}
    public void setCity(String city){this.City = city;}
    public void setAddress(String address){this.Address = address;}
    public void setDescription(String max){this.Description = max;}
    public void setGender(String gender){this.Gender = gender;}
    public void setPrice(int price){this.Price = price;}


    public String isHas_Wifi() {
        return Has_Wifi;
    }

    public void setHas_Wifi(String has_Wifi) {
        Has_Wifi = has_Wifi;
    }

    public String isAllow_Pets() {
        return Allow_Pets;
    }

    public void setAllow_Pets(String allow_Pets) {
        Allow_Pets = allow_Pets;
    }

    public String isAllow_Smoking() {
        return Allow_Smoking;
    }

    public void setAllow_Smoking(String allow_Smoking) {
        Allow_Smoking = allow_Smoking;
    }

    public String ShowDetails() {
        return String.format("%o | %o | %s | %s | %s | %d | %s | %s | %s | %s", Post_ID, User_ID, City, Address, Description, Price, Gender, Has_Wifi, Allow_Pets, Allow_Smoking);
    }
}
