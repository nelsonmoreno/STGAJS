package co.edu.stg.server;



import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;


public class ServletContextListener extends GuiceServletContextListener {
	 
	  @Override
	  protected Injector getInjector() {
		  return Guice.createInjector(new Module(), new ServicesServletModule());
	  }
}