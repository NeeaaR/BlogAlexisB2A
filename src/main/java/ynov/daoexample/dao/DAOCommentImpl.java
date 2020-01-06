package ynov.daoexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ynov.daoexample.model.Comment;

public class DAOCommentImpl implements DAOComment {
	private Connection connection;
	java.util.Date date;
	java.sql.Date sqldate;
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	public DAOCommentImpl(Connection co) {
		// TODO Auto-generated constructor stub
		this.connection = co;
	}
	
	public List<Comment> getAllCommentaires(int id) {
		List<Comment>comments = new ArrayList<Comment>();
		try {
			String query = "SELECT utilisateur,commentaire,c.date, id_commentaire FROM utilisateur u, commentaire c, article a where u.id_utilisateur = c.id_utilisateur and c.id_utilisateur = u.id_utilisateur and a.id_article = c.id_article and c.id_article = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setUtilisateur(rs.getString("utilisateur"));
				comment.setCommentaire(rs.getString("commentaire"));
				comment.setDate(rs.getDate("date"));
				comment.setId_commentaire(rs.getInt("id_commentaire"));
				
				comments.add(comment);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}
	
}
