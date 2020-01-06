package ynov.alexis.servlets;

import ynov.daoexample.dao.DAOArticles;
import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.dao.DAOUser;
import ynov.daoexample.model.Articles;
import ynov.daoexample.model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddArticle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
	
	this.getServletContext().getRequestDispatcher("/addarticle.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String auteur = req.getParameter("auteur");
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
		String article = req.getParameter("texte");
		
		DAOFactory factory = new DAOFactory();
		DAOArticles daoArticles = factory.getDaoArticles();
		
		Articles a = new Articles();
		a.setAuteur(auteur);
		a.setTitre(titre);
		a.setDescription(description);
		a.setTexte(article);
		daoArticles.addArticle(a);
		
		this.getServletContext().getRequestDispatcher("/addarticle.jsp").forward(req, resp);
	}
	
}