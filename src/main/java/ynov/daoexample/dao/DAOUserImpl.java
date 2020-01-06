package ynov.daoexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import ynov.daoexample.model.Articles;
import ynov.daoexample.model.User;

public class DAOUserImpl implements DAOUser {
	private Connection connection;

	public DAOUserImpl(Connection co) {
		// TODO Auto-generated constructor stub
		this.connection = co;
	}

	public User getUser(int id) {
		User user = new User();
		try {
			String query = "SELECT * FROM utilisateur WHERE id_utilisateur =?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				user.setUtilisateur(resultat.getString("utilisateur"));
				user.setMdp(resultat.getString("mdp"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			String query = "Select * FROM utilisateur";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				
				user.setId_utilisateur(rs.getInt("id_utilisateur"));
				user.setUtilisateur(rs.getString("utilisateur"));
				user.setMdp(rs.getString("mdp"));
				users.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	
	public void addUser(User user) {
		try {
			String query = "INSERT INTO utilisateur (utilisateur, mdp) VALUES (?,?)";	
			String generatedColumns[] = {"id_utilisateur"};
			PreparedStatement ps = connection.prepareStatement(query, generatedColumns);
			ps.setString(1, user.getUtilisateur());
			ps.setString(2, user.getMdp());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				user.setId_utilisateur(rs.getInt(1));
			}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}

	}

	public User LoginUser(User user) {
		try {
			String query = "SELECT * FROM utilisateur WHERE utilisateur = ? and mdp = ?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getUtilisateur());
			ps.setString(2, user.getMdp());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Connecté");
				user.setId_utilisateur(rs.getInt("id_utilisateur"));
			}
			else {
				System.out.println("Utilisateur ou mot de passe érroné");	
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

}