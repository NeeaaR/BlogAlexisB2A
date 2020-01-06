package ynov.daoexample.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import ynov.daoexample.model.Articles;


public class DAOArticlesImpl implements DAOArticles {
	private Connection connection;
	
java.util.Date date;
java.sql.Date sqldate;
	
	public DAOArticlesImpl(Connection co) {
		// TODO Auto-generated constructor stub
		this.connection = co;
	}
	
	public Articles getArticle(int id) {
		Articles articles = new Articles();
		try {
			String query = "SELECT * FROM article WHERE id_article = ?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				articles.setAuteur(resultat.getString("auteur"));
				articles.setTitre(resultat.getString("titre"));
				articles.setDescription(resultat.getString("description"));
				articles.setTexte(resultat.getString("texte"));
				articles.setDate(resultat.getDate("date"));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		return articles;
	}
	
	public List<Articles> getAllArticles() {
		List<Articles> articles = new ArrayList<Articles>();
		try {
			String query = "SELECT * FROM article";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Articles article = new Articles();
				article.setId_article(rs.getInt("id_article"));
				article.setAuteur(rs.getString("auteur"));
				article.setTitre(rs.getString("titre"));
				article.setDescription(rs.getString("description"));
				article.setTexte(rs.getString("texte"));
				article.setDate(rs.getDate("date"));
				
				articles.add(article);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	public List<Articles> getRecentArticles() {
		List<Articles> articles = new ArrayList<Articles>();
		try {
			String query = "SELECT * FROM article GROUP BY date DESC LIMIT 0,2";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Articles article = new Articles();
				article.setId_article(rs.getInt("id_article"));
				article.setAuteur(rs.getString("auteur"));
				article.setTitre(rs.getString("titre"));
				article.setDescription(rs.getString("description"));
				article.setTexte(rs.getString("texte"));
				article.setDate(rs.getDate("date"));
				
				articles.add(article);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	public void addArticle(Articles articles) {
		try {
			String query = "INSERT INTO article (auteur,titre,description,texte,date) VALUES (?,?,?,?,?);";
			String generatedColumns[] = {"ID"};
			PreparedStatement ps = connection.prepareStatement(query, generatedColumns);
			ps.setString(1, articles.getAuteur());
			ps.setString(2, articles.getTitre());
			ps.setString(3, articles.getDescription());
			ps.setString(4, articles.getTexte());
			ps.setDate(5, getCurrentDate());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {	
				articles.setId_article(rs.getInt(1));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void updateArticle(Articles article) {
		try {
			String query = "UPDATE article SET auteur=?, titre=?, description=?, texte=? WHERE id_article=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, article.getAuteur());
			ps.setString(2, article.getTitre());
			ps.setString(3, article.getDescription());
			ps.setString(4, article.getTexte());
			ps.setDate(5, getCurrentDate());
			ps.setInt(5, article.getId_article());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	public void deleteArticle(Articles article) {
		try {
			String query = "DELETE FROM article WHERE id_article=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, article.getId_article());
						
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Articles> getAllAuthors() {
		List<Articles> articles = new ArrayList<Articles>();
		try {
			String query = "SELECT DISTINCT auteur FROM article";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Articles article = new Articles();
				article.setAuteur(rs.getString("auteur"));
				articles.add(article);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	public List<Articles> getAuthorArticles(String auteur) {
		List<Articles> articles = new ArrayList<Articles>();
		try {
			String query = "SELECT titre FROM article WHERE auteur = ?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, auteur);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Articles article = new Articles();
				article.setTitre(resultat.getString("titre"));
				articles.add(article);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		return articles;
	}
}
