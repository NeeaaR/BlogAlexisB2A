package ynov.daoexample.dao;
import java.sql.SQLException;
import java.util.List;
import ynov.daoexample.model.User;

public interface DAOUser {
	public User getUser(int id);
	public List<User> getAllUsers();
	public void addUser(User user);
	public User LoginUser(User user);
}
