package bdd;

import java.sql.*;

public class DbConnection {

	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	/*---------------------URL pour trouver la BDD � condition qu'elle soit d�j� cr��e----------------------*/
	static final String DB_URL = "jdbc:mysql://localhost/projetJavaEE";

	/*---------------------les identifiants pour se connecter � la BDD----------------------*/
	static final String USER = "votre nom d'utilisateur";
	static final String PASS = "votre mot de passe";

	/*---------------------la connexion � la bdd----------------------*/
	private static Connection connection; 

	/*---------------------Connexion � la base de donn�es----------------------*/
	public static Connection getInstance()
	{
		if (null == connection) {
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL,USER,PASS);
			} catch (ClassNotFoundException e) {
				//Class.forName failed
				e.printStackTrace();
			} catch (SQLException e) {
				//DriverManager.getConnection failed
				e.printStackTrace();
			}
		}
		return connection;
	}

	/*---------------------Fermeture de la connexion----------------------*/
	public static void close()
	{
		try{
			if(connection != null) {
				connection.close();
				connection = null;
			}
		} catch(SQLException se){
			se.printStackTrace();
		}	
	}
	
	
}
