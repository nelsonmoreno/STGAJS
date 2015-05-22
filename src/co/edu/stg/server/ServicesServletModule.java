package co.edu.stg.server;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;


public class ServicesServletModule extends ServletModule {
	 
	  @Override
	  protected void configureServlets() {
	    final Map<String, String> params = new HashMap<String, String>();
	    params.put("javax.ws.rs.Application",
	        "co.com.tapptus.portal.server.PortalRestApplication");
	    serve("/rest/*").with(GuiceContainer.class, params);
	   // filter("/*").through(ObjectifyFilter.class);
	  }
}