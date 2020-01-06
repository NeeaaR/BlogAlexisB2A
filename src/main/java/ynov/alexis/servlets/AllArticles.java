package ynov.alexis.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.daoexample.dao.DAOArticles;
import ynov.daoexample.dao.DAOComment;
import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.model.Articles;
import ynov.daoexample.model.Comment;

public class AllArticles extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		DAOFactory factory = new DAOFactory();
		DAOArticles daoArticles = factory.getDaoArticles();
		List<Articles>articles = daoArticles.getAllArticles();
		
		req.setAttribute("articles", articles);
		
		System.out.println("ALL ARTICLE");
		
		this.getServletContext().getRequestDispatcher("/allarticles.jsp").forward(req, resp);
	}	
	
}