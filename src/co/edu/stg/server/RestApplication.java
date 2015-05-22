package co.edu.stg.server;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;


 


@Path("/rest")
public class RestApplication  extends Application {
	 
/*	  @Inject
	  AbstractProvider<Comercio> comercioService;
	  
	  @Inject
	  AbstractProvider<Categoria> categoriaService;

	  @Inject
	  AbstractProvider<Producto> producoService;
	  
	  @Inject
	  AbstractProvider<Anuncio> anuncioService;
	  
	  @Inject
	  AbstractProvider<Usuario> usuarioService;
	  
	  @Inject
	  AbstractProvider<Visita> visitaService;
	  
	  @Inject
	  AbstractProvider<Rol> rolService;
	  
	  @Override
	  public Set<Object> getSingletons() {
	    return new HashSet<Object>(Arrays.asList(new Object[] { comercioService, categoriaService, producoService, anuncioService, usuarioService, visitaService, rolService }));
	  }*/
}