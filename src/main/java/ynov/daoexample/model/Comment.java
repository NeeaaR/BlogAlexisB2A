package ynov.daoexample.model;

import java.util.Date;

public class Comment {
	private int id_commentaire;
	private String utilisateur;
	private String commentaire;
	private Date date;
	
	public int getId_commentaire() {
	return id_commentaire;
	}
	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public String getUtilisateur() {
		return utilisateur;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
}
