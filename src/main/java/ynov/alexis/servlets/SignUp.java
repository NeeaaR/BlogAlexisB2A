package ynov.alexis.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.daoexample.dao.DAOArticles;
import ynov.daoexample.dao.DAOFactory;
import ynov.daoexample.dao.DAOUser;
import ynov.daoexample.model.Articles;
import ynov.daoexample.model.User;

public class SignUp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String utilisateur = req.getParameter("utilisateur");
		String mdp = req.getParameter("mdp");
		
		System.out.println(utilisateur);
		
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();
		
		User u = new User();
		u.setUtilisateur(utilisateur);
		u.setMdp(mdp);
		
		daoUser.addUser(u);
		
		this.getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
	}
	
}
