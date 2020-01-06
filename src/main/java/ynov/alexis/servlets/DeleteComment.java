package ynov.alexis.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.daoexample.dao.DAOArticles;
import ynov.daoexample.dao.DAOComment;
import ynov.daoexample.dao.DAOComments;
import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.model.Articles;
import ynov.daoexample.model.Comment;
import ynov.daoexample.model.Comments;

public class DeleteComment extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		DAOFactory factory = new DAOFactory();
		DAOComments daoComments = factory.getDaoComments();
		
		Comments c = new Comments();
		c.setId_commentaire(id);
		
		daoComments.deleteCommentaire(c);
		
		
		this.getServletContext().getRequestDispatcher("/deletecomment.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
}