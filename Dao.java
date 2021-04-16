package bdd;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Dao implements UserDao {

	
	private ServletContext storage;
	private static String STORAGE_KEY = "user-dao-storage-users";
	
	/*---------insert an user----------*/
	@Override
	public void insert(User user) throws UserAlreadyExistsException {
		if (null == user) {
			return;
		}
		List<User> users = fetchAll();
		for (User u: users) {
			if (u.getUsername().equals(user.getUsername())) {
				throw new UserAlreadyExistsException();
			}
		}
		users.add(user);
		storage.setAttribute(STORAGE_KEY, users);
	}

	/*--------- delete an user---------*/
	@Override
	public void delete(User u) {
		List<User> users = fetchAll();
		for (int i = 0; i < users.size(); i++) {
			// If the user exists, remove it and synchronize it with the storage
			if (users.get(i).getUsername() == u.getUsername()) {
				users.remove(i);
				storage.setAttribute(STORAGE_KEY, users);
				break;
			}
		}
	}

	/*-------- visualiser tout les tuples----------*/
	@Override
	public List<User> fetchAll() {
		Object users = storage.getAttribute(STORAGE_KEY);
		if (null == users) {
			return new ArrayList<User>();
		}
		return (ArrayList<User>)users;
	}
	
	public Dao setStorage(ServletContext storage)
	{
		this.storage = storage;
		return this;
	}

}
