package ma.ensate.sturent.Property;

import javax.persistence.*;

@Entity(name = "property") // This tells Hibernate to make a table out of this class
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Property_ID;
    private String Address;
    private String City;
    private int MaxCapacity;
    private int AvailableCapacity;
    private int Price;

    public Property() { }
    public Property(int ID, String city, String address, int max, int available, int price) {
        setPropertyID(ID);
        setCity(city);
        setAddress(address);
        setMaxCapacity(max);
        setAvailableCapacity(available);
        setPrice(price);
    }
    public Property(String city, String address, int max, int available, int price) {
        setPropertyID(0);
        setCity(city);
        setAddress(address);
        setMaxCapacity(max);
        setAvailableCapacity(available);
        setPrice(price);
    }

    public int getPropertyID(){return this.Property_ID;}
    public String getAddress(){return this.Address;}
    public String getCity(){return this.City;}
    public int getMaxCapacity(){return this.MaxCapacity;}
    public int getAvailableCapacity(){return this.AvailableCapacity;}
    public int getPrice(){return this.Price;}

    public void setPropertyID(int ID){this.Property_ID = ID;}
    public void setAddress(String address){this.Address = address;}
    public void setCity(String city){this.City = city;}
    public void setMaxCapacity(int max){this.MaxCapacity = max;}
    public void setAvailableCapacity(int available){this.AvailableCapacity = available;}
    public void setPrice(int price){this.Price = price;}
}
