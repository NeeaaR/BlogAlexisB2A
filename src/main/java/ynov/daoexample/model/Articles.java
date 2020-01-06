package ynov.daoexample.model;

import java.sql.Date;

public class Articles {
	private int id_article;
	private String auteur;
	private String titre;
	private String description;
	private String texte;
	private Date date;
	
	
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getAuteur() {
		return auteur;
	}
	public String getTitre() {
		return titre;
	}
	public String getDescription() {
		return description;
	}
	public String getTexte() {
		return texte;
	}
	public Date getDate() {
		return date;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
