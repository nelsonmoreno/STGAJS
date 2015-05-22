package co.edu.stg.server;


import com.google.appengine.api.datastore.Key;


public abstract class DomainObject {

	/*private String ide;
	
	private Long id;

	public String getIde() {
		return ide;
	}

	public void setIde(String ide) {
		this.ide = ide;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/
	
	public abstract long getId();
	public abstract void setKey(Key key);
	public abstract Key getKey();
 
}
