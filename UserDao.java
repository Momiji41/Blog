package bdd;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public interface UserDao {
	
	void insert(User user) throws UserAlreadyExistsException;
	
	void delete(User u);
	
	List<User> fetchAll();
	
	
}
