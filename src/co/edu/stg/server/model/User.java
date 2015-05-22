package co.edu.stg.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.edu.stg.server.DomainObject;

import com.google.appengine.api.datastore.Key;



@Entity
public class User extends DomainObject{

	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	@Override
    public long getId() {
		if(null!=key){
			return key.getId();
		}else{
			return 0;
		}
    }

	private String name;
	private String email;
	private String phone;
	private String disclamer;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDisclamer() {
		return disclamer;
	}
	public void setDisclamer(String disclamer) {
		this.disclamer = disclamer;
	}
	@Override
	public void setKey(Key key){
		this.key=key;
	}
	@Override
	public Key getKey() {
		return this.key;
	}
}
