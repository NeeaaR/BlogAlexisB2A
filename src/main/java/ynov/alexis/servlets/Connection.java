package ynov.alexis.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.daoexample.dao.DAOArticles;
import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.dao.DAOUser;
import ynov.daoexample.model.Articles;
import ynov.daoexample.model.User;

public class Connection extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/connection.jsp").forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String utilisateur = req.getParameter("utilisateur");
		String mdp = req.getParameter("mdp");
		
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();
		User u = new User();
		u.setUtilisateur(utilisateur);
		u.setMdp(mdp);	
		
		daoUser.LoginUser(u);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("utilisateur", utilisateur);
		session.setAttribute("id_utilisateur", daoUser.LoginUser(u).getId_utilisateur());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
}