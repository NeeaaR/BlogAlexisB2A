package ynov.daoexample.dao;

import java.util.List;
import ynov.daoexample.model.Comments;

public interface DAOComments {
	public DAOComments getCommentaire(int id);
	public List<Comments> getAllCommentaires(int id);
	public void addCommentaire(Comments comment);
	public void deleteCommentaire(Comments comment);
}
