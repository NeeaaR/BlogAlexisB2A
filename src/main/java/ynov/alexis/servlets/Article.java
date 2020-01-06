package ynov.alexis.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.daoexample.dao.DAOArticles;
import ynov.daoexample.dao.DAOComment;
import ynov.daoexample.dao.DAOComments;
import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.model.Articles;
import ynov.daoexample.model.Comment;
import ynov.daoexample.model.Comments;

public class Article extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		DAOFactory factory = new DAOFactory();
		DAOArticles daoArticles = factory.getDaoArticles();
		DAOComment daoComment = factory.getDaoComment();
		List<Comment>comment = daoComment.getAllCommentaires(id);
		req.setAttribute("commentaires", comment);
		req.setAttribute("article", daoArticles.getArticle(id));
		
		
		
		this.getServletContext().getRequestDispatcher("/article.jsp").forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String auteur = req.getParameter("auteur");
		String commentaire = req.getParameter("commentaire");
		int id_utilisateur = Integer.parseInt(req.getParameter("id_utilisateur"));
		
		System.out.println(commentaire);
		
		DAOFactory factory = new DAOFactory();
		DAOComments daoComments = factory.getDaoComments();
		
		Comments c = new Comments();
		c.setCommentaire(commentaire);
		c.setId_article(id);
		c.setId_utilisateur(id_utilisateur);
		
		daoComments.addCommentaire(c);
		
		System.out.println("envoyer");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}