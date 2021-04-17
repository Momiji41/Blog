package bdd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletUserDao
 */
@WebServlet("/ServletUserDao")
public class ServletUserDao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		Dao dao = new Dao();
		// Fetch all users from the database
		List<User> users = dao.fetchAll();
		// Loop over them to display their informations
		for (User u: users) {
			out.print("ID: " + u.getId());
			out.print(" | Firstname: " + u.getFirstname());
			out.print(" | Lastname: " + u.getLastname());
			out.print(" | username: " + u.getUsername());
			out.print(" | password: **************");
			out.println("");
		}
		// Close the connection to the database
		DbConnection.close();
	}
	
}

