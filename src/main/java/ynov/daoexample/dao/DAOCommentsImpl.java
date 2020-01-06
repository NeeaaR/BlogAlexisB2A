package ynov.daoexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ynov.daoexample.model.Articles;
import ynov.daoexample.model.Comment;
import ynov.daoexample.model.Comments;
import ynov.daoexample.model.User;

public class DAOCommentsImpl implements DAOComments{
	private Connection connection;
	java.util.Date date;
	java.sql.Date sqldate;
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	public DAOCommentsImpl(Connection co) {
		// TODO Auto-generated constructor stub
		this.connection = co;
	}
	
	public DAOComments getCommentaire(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Comments> getAllCommentaires(int id) {
		return null;
	}
	
	public void addCommentaire(Comments comment) {
		try {
			String query = "INSERT INTO commentaire (commentaire,id_article,id_utilisateur,date) VALUES (?,?,?,?);";
			String generatedColumns[] = {"ID"};
			PreparedStatement ps = connection.prepareStatement(query, generatedColumns);
			ps.setString(1,	comment.getCommentaire());
			ps.setInt(2, comment.getId_article());
			ps.setInt(3, comment.getId_utilisateur());
			ps.setDate(4, getCurrentDate());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {	
				comment.setId_commentaire(rs.getInt(1));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteCommentaire(Comments comment) {
		try {
			String query = "DELETE FROM commentaire WHERE id_commentaire = ?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, comment.getId_commentaire());
						
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
