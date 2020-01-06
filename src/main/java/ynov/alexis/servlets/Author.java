package ynov.alexis.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.daoexample.dao.DAOArticles;
import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.model.Articles;

public class Author extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String author = req.getParameter("nom");
		System.out.println(author);
		DAOFactory factory = new DAOFactory();
		DAOArticles daoArticles = factory.getDaoArticles();
		List<Articles>auteur = daoArticles.getAuthorArticles(author);
		req.setAttribute("auteur", auteur);
		
		
		
		this.getServletContext().getRequestDispatcher("/author.jsp").forward(req, resp);
	}	
}