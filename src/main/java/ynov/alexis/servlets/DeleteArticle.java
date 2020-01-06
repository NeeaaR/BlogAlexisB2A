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

public class DeleteArticle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		DAOFactory factory = new DAOFactory();
		DAOArticles daoArticles = factory.getDaoArticles();
		
		Articles a = new Articles();
		a.setId_article(id);
		
		daoArticles.deleteArticle(a);
		
		
		this.getServletContext().getRequestDispatcher("/deletearticle.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
}