package ynov.daoexample.dao;

public class DAOFactory {
	private MySQLManager manager;
	private DAOUser daoUser;
	private DAOArticles daoArticles;
	private DAOComments daoComments;
	private DAOComment daoComment;
	public DAOFactory() {
		manager = MySQLManager.getInstance();
		daoUser = new DAOUserImpl(manager.getConnection());
		daoArticles = new DAOArticlesImpl(manager.getConnection());
		daoComments = new DAOCommentsImpl(manager.getConnection());
		daoComment = new DAOCommentImpl(manager.getConnection());
	}
	
	public DAOUser getDaoUser() {
		return daoUser;
	}
	
	public DAOArticles getDaoArticles() {
		return daoArticles;
	}
	public DAOComment getDaoComment() {
		return daoComment;
	}
	public DAOComments getDaoComments() {
		return daoComments;
	}
	
	
}
