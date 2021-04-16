package bdd;

/**
 * Represent a user in the application.
 */
public class User {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password1;
	
	/*---- récupérer le first name -----*/
	public String getFirstname() {
		return firstname;
	}
	
	/*---- Définir le first name -----*/
	public User setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	/*---- récupérer le last name -----*/
	public String getLastname() {
		return lastname;
	}
	
	/*---- Définir le last name -----*/
	public User setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	/*---- récupérer le nom d'utilisateur -----*/
	public String getUsername() {
		return username;
	}
	/*---- Définir le nom d'utilisateurs -----*/
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	/*---- Définir le password1 -----*/
	public String getPassword() {
		return password1;
	}
	
	/*---- Définir le password1 -----*/
	public User setPassword(String password) {
		this.password1 = password;
		return this;
	}
	
	
}
