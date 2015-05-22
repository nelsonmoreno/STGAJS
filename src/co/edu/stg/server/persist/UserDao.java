package co.edu.stg.server.persist;

import co.edu.stg.server.AbstractDao;
import co.edu.stg.server.model.User;



public class UserDao extends AbstractDao<User> {

	public UserDao() {
		super(User.class);
	}
	
}