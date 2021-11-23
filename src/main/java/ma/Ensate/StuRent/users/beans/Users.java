package ma.ensate.sturent.users.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {

	private String username;
	@Id
	@Column(nullable= false)
	private String email;
	@Column(nullable= false)
	private String password;
	private String gender;
	private int phone;
	private int isAdmin;

	public Users(){}
	public Users(String username,String email, String password,String gender, int phone,int isAdmin){
		setUsername(username);
		setEmail(email);
		setPassword(password);
		setGender(gender);
		setPhone(phone);
		setAdmin(isAdmin);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int isAdmin() {
		return isAdmin;
	}
	public void setAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
