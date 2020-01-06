package ynov.daoexample.model;

public class User {
	private int id_utilisateur;
	private String utilisateur;
	private String mdp;

	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public String getUtilisateur() {
		return utilisateur;
	}
	public String getMdp() {
		return mdp;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}

