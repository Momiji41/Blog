package bdd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Dao implements UserDao {

	
	private ServletContext storage;
	private static String STORAGE_KEY = "user-dao-storage-users";
	
	/*-----------------------insert an user---------------------------*/
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

	/*---------------------- delete an user------------------------*/
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

	private String strSQL = "Select id,first_name,last_name,username,password from user";
	
	/*------------------------- visualiser tout les tuples-------------------------*/
	@Override
	public List<User> fetchAll() {
		List<User> users = new ArrayList<User>();
		Connection connection = DbConnection.getInstance();
		Statement stmt;

		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			// Loop over the database result set and create the
			// user objects.
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setFirstname(rs.getString("firstname"));
				u.setLastname(rs.getString("lastname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("Password"));
				users.add(u);
			}
			// Free resources
			rs.close();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return users;
	}
	
	public Dao setStorage(ServletContext storage)
	{
		this.storage = storage;
		return this;
	}

}

