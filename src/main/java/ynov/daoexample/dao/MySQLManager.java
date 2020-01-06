package ynov.daoexample.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {
	private static MySQLManager instance = null;
	private Statement statement = null;
	private Connection connection = null;
	private String url = "jdbc:mysql://localhost:3306/blogalexis?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private String utilisateur = "root";
	private String motDePasse = "";
	
	public static synchronized MySQLManager getInstance() {
		if (instance == null) {
		     instance = new MySQLManager();
	}	
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	

private MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			this.statement = this.connection.createStatement();
			}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
}

public void requetepreparee(String paramMail, String paramPass) {
	try {
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO User (mail, password) VALUES (?,?);");
		
		preparedStatement.setString(1, paramMail);
		preparedStatement.setString(2, paramPass);
		
		int statut = preparedStatement.executeUpdate();
		
	} catch(SQLException e) {
		System.out.println(e.getMessage());
	}
}

@Override
protected void finalize() throws Throwable {
	if(connection != null) {
		try {
			connection.close();
		} catch (SQLException e) {
			
		}
	}
	super.finalize();
}

}

