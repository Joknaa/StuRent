package ma.ensate.sturent.AddOffer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Offer {
    private long id;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Offer_ID;
    private String Title;
    private String City;
    private String Address;
    private String Description;
    private int Gender;
    private int Price;

    public Offer() { }
    public Offer(int ID, String title, String address, String description, int price) {
        setPropertyID(ID);
        setTitle(title);
        setAddress(address);
        setDescription(description);
        setPrice(price);
    }
    public Offer(String title, String address, String description, int price) {
        setPropertyID(0);
        setTitle(title);
        setAddress(address);
        setDescription(description);
        setPrice(price);
    }

    public int getPropertyID(){return this.Offer_ID;}
    public String getAddress(){return this.Address;}
    public String getTitle(){return this.Title;}
    public String getDescription(){return this.Description;}
    public int getPrice(){return this.Price;}

    public void setPropertyID(int ID){this.Offer_ID = ID;}
    public void setAddress(String address){this.Address = address;}
    public void setTitle(String title){this.Title = title;}
    public void setDescription(String max){this.Description = max;}
    public void setPrice(int price){this.Price = price;}
}
