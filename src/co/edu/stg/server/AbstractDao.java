package co.edu.stg.server;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;









public abstract class AbstractDao<T> implements Dao<T> {



	private final Class<T> clazz;

	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		/*List<T> lth = ObjectifyService.ofy().transact(new Work<List<T>>() {
		    public List<T> run() {*/
		        //return ObjectifyService.ofy().load().type(clazz).list();
		/*    }
		});
		return lth;*/
		        
		List<T> list = new ArrayList<T>();
        EntityManager em = EMF.get().createEntityManager();
		try{
			em.getTransaction().begin();
	        Query q = em.createQuery("SELECT c FROM " + clazz.getName() +" c");
	        list = q.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		    if (em.getTransaction().isActive()) {
		        em.getTransaction().rollback();
		    }			
			em.close();
		}
		return list;

	}


	
	@Override
	public List<T> filterBy(final String attribute, final Object value) { 
		//List<T> lth = ObjectifyService.ofy().transact(new Work<List<T>>() {
		//    public List<T> run() {
		List<T> list = new ArrayList<T>();
		EntityManager em = EMF.get().createEntityManager();
		try{
			em.getTransaction().begin();
		        if(null!=attribute){
		        	int indexOfKey=attribute.indexOf("key")-1;
		        	if(indexOfKey>0){
		        		String simpleClassName = attribute.substring(0,indexOfKey);
		        		simpleClassName = simpleClassName.toLowerCase();
		        		simpleClassName = Character.toString(simpleClassName.charAt(0)).toUpperCase()+simpleClassName.substring(1);
		        		String className = "co.com.tapptus.portal.model."+simpleClassName;
		        		Class parameterClass = Class.forName(className);
		        		long id =Long.parseLong(value.toString());
						if(0<id){
							Key key = KeyFactory.createKey(simpleClassName, id);		        		
							T template = (T)em.find(parameterClass, key);
							if(null!=template){
						        String query = "select from "+clazz.getName()+" c where c."+attribute.substring(0,indexOfKey)+" = :parameter";
						        System.out.println(query);
						        Query q = em.createQuery(query);
						        q.setParameter(0,template);
						        System.out.println( "q " +q);
						        list = q.getResultList();
						        if(null!=list){
							        System.out.println( "list " +list);		        	
						        }else{
						        	System.out.println( "list is null");
						        }								
							}
						}
		        	}else{
				        String query = "select from "+clazz.getName()+" c where c."+attribute+" = :parameter";
				        System.out.println(query);
				        Query q = em.createQuery(query);
				        q.setParameter("parameter", value);
				        System.out.println( "q " +q);
				        list = q.getResultList();
				        if(null!=list){
				        	T [] a =(T[]) list.toArray();
					        System.out.println( "list " +list);		        	
				        }else{
				        	System.out.println( "list is null");
				        }		        		
		        	}
		        }


		}catch(Exception e){
			e.printStackTrace();
		}finally{
		    if (em.getTransaction().isActive()) {
		        em.getTransaction().rollback();
		    }			
			em.close();
		}
		//List<T> list = ObjectifyService.ofy().load().type(clazz).filter(attribute, value).list();
		//        return list;
		        //    }
		        //});
		        //return lth;
		return list;
	}


	@Override
	public T persist(T t) {
		EntityManager em = EMF.get().createEntityManager();
		
		try{
			em.getTransaction().begin();
			if(null!=t){
				long id = ((DomainObject)t).getId();
				if(0<id){
					Key key = KeyFactory.createKey(clazz.getSimpleName(), id);
					T template = em.find(clazz, key);
					if(null!=template){
						//((DomainObject)t).setKey(((DomainObject)template).getKey(key));
						((DomainObject)t).setKey(((DomainObject)template).getKey());
						em.merge(t);
						em.getTransaction().commit();
					}
				}else{
					em.persist(t);
					em.flush();
					em.getTransaction().commit();
					 
				}
			}

		/*Result<Key<T>> result= ObjectifyService.ofy().save().entity(t);
		result.now();
		return t;

		Objectify ofy = ObjectifyService.beginTransaction();
		try {

			ofy.put(t);
			ofy.getTxn().commit();
		} finally {
			if (ofy.getTxn().isActive()) {
				System.out.println("Roooollllbackkkk!!");
				ofy.getTxn().rollback();
			}

		}
		return t;*/
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		    if (em.getTransaction().isActive()) {
		        em.getTransaction().rollback();
		    }			
			em.close();
		}
		return t;
	}

	@Override
	public void delete(T t) {
		//ObjectifyService.begin().delete(t);
	}

	@Override
	public T find(Long id) {
		EntityManager em = EMF.get().createEntityManager();
		Key key = KeyFactory.createKey(clazz.getSimpleName(), id);		        		
		return (T)em.find(clazz, key);
	}

	@Override
	public T find(String id) {
		
		return null;
	}

}
