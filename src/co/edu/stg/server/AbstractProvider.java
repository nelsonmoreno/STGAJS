package co.edu.stg.server;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;



import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractProvider<T extends DomainObject> {
	 
	  //@Inject
	  protected Dao<T> dao;
	   
	  private final Class<T> clazz;
	   
	  public AbstractProvider(Class<T> clazz) {
	    this.clazz = clazz;
	    dao = new AbstractDao<T>(clazz) {
		};
	  }
	   
	  @POST
	  @Path("/persist")
	  public String persist(String body) {
	    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    final T t = gson.fromJson(body, clazz);
	    return gson.toJson(dao.persist(t));
	  }
	  
	  
	  protected String getCurrentUser(){
		  String email=null;
		  UserService userService = UserServiceFactory.getUserService();
		  User user = userService.getCurrentUser();
		  if (user != null) {
		       email = user.getEmail();
		  }
		  return email;
	  }
	  
	  protected String getLogoutUrl(){
		  String logoutUrl=null;
		  UserService userService = UserServiceFactory.getUserService();
		  User user = userService.getCurrentUser();
		  if (user != null) {
			  logoutUrl = userService.createLogoutURL("/index.html");
		  }
		  return logoutUrl;
	  }
	  
	  protected String getLoginUrl(){
		  String loginUrl=null;
		  UserService userService = UserServiceFactory.getUserService();
		  userService.getCurrentUser();
			  loginUrl = userService.createLoginURL("/portal");
		  return loginUrl;
	  }
	  
}
