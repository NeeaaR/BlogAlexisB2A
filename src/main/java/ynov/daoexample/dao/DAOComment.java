package ynov.daoexample.dao;

import java.util.List;

import ynov.daoexample.model.Articles;
import ynov.daoexample.model.Comment;
import ynov.daoexample.model.Comments;

public interface DAOComment{
	public List<Comment> getAllCommentaires(int id);
}
