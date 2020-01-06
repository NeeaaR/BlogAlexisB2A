package ynov.daoexample.dao;
import java.util.List;

import ynov.daoexample.model.Articles;

public interface DAOArticles {
	public Articles getArticle(int id);
	public List<Articles> getAllArticles();
	public void addArticle(Articles articles);
	public void updateArticle(Articles article);
	public void deleteArticle(Articles article);
	public List<Articles> getRecentArticles();
	public List<Articles> getAllAuthors();
	public List<Articles> getAuthorArticles(String auteur);
}
