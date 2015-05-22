package co.edu.stg.server;

import java.util.List;

public interface Dao<T> {

	T find(Long id);

	T find(String id);

	List<T> findAll();
		
	List<T> filterBy(String atribute, Object value);

	T persist(T t);

	void delete(T t);
	
	
}