package ynov.daoexample.model;

import java.util.Date;

public class Comments {
	private int id_commentaire;
	private String commentaire;
	private Date date;
	private int id_article;
	private int id_utilisateur;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId_commentaire() {
		return id_commentaire;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public int getId_article() {
		return id_article;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
}
