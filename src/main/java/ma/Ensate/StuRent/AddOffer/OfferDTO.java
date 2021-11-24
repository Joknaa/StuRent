package ma.Ensate.StuRent.AddOffer;

import com.sun.istack.NotNull;

public class OfferDTO {
    @NotNull
    private Long Post_ID = 1L;
    @NotNull
    private String User_Name;
    @NotNull
    private String Title = "";
    @NotNull
    private String City = "";
    private String Address = "";
    @NotNull
    private String Gender = "";
    private String Description = "";
    @NotNull
    private int Price = 0;
    private String Has_Wifi = "";
    private String Allow_Pets = "";
    private String Allow_Smoking = "";
    private String Images;

    private boolean CheckBox_Male = false;
    private boolean CheckBox_Female = false;
    private boolean CheckBox_wifi= false;
    private boolean CheckBox_pets= false;
    private boolean CheckBox_smoking= false;

    @NotNull
    private String Phone;



    public boolean isCheckBox_wifi() {
        return CheckBox_wifi;
    }

    public void setCheckBox_wifi(boolean checkBox_wifi) {
        CheckBox_wifi = checkBox_wifi;
    }

    public boolean isCheckBox_pets() {
        return CheckBox_pets;
    }

    public void setCheckBox_pets(boolean checkBox_pets) {
        CheckBox_pets = checkBox_pets;
    }

    public boolean isCheckBox_smoking() {
        return CheckBox_smoking;
    }

    public void setCheckBox_smoking(boolean checkBox_smoking) {
        CheckBox_smoking = checkBox_smoking;
    }


    public String getImages() {return Images;}

    public void setImages(String images) {Images = images;}

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

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isCheckBox_Male() {
        return CheckBox_Male;
    }

    public void setCheckBox_Male(boolean checkBox_Male) {
        CheckBox_Male = checkBox_Male;
    }

    public boolean isCheckBox_Female() {
        return CheckBox_Female;
    }

    public void setCheckBox_Female(boolean checkBox_Female) {
        CheckBox_Female = checkBox_Female;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
