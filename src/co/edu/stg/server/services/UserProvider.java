package co.edu.stg.server.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.stg.server.AbstractProvider;
import co.edu.stg.server.model.User;

@Path("/user")
public class UserProvider extends AbstractProvider<User> {

	public UserProvider() {
		super(User.class);
	}
	
	
	
	  @GET
	  @Path("/getbyuser/{atribute}/{value}")
	  public String get(@PathParam("atribute") String atribute, @PathParam("value") String value) {
	    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
	    
/*	    	PortalPersistCtrl portalPersistCtrl = new PortalPersistCtrl();
	    	List<Comercio> list= portalPersistCtrl.getStoresByUser(Comercio.class,value);
	    	String a = gson.toJson(list);
	    	return a;*/
	    	
		    String json = "[]";
		    if (null!=atribute&&atribute.trim().length()>0) {
		    	if (null!=value&&value.trim().length()>0) {
		    		json = gson.toJson(dao.filterBy(atribute, value));
		    	}
		    }
		    return json;

	  }
	  
	  
}

