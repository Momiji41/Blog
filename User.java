package bdd;

/**
 * Represent a user in the application.
 */
public class User {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password1;
	
	/*---- r�cup�rer le first name -----*/
	public String getFirstname() {
		return firstname;
	}
	
	/*---- D�finir le first name -----*/
	public User setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	/*---- r�cup�rer le last name -----*/
	public String getLastname() {
		return lastname;
	}
	
	/*---- D�finir le last name -----*/
	public User setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	/*---- r�cup�rer le nom d'utilisateur -----*/
	public String getUsername() {
		return username;
	}
	/*---- D�finir le nom d'utilisateurs -----*/
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	/*---- D�finir le password1 -----*/
	public String getPassword() {
		return password1;
	}
	
	/*---- D�finir le password1 -----*/
	public User setPassword(String password) {
		this.password1 = password;
		return this;
	}
	
	
}
