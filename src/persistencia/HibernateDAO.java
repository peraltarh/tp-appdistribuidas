package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateDAO {
	protected static HibernateDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;

	
	public static HibernateDAO getInstancia(){
		if(instancia == null){
			instancia = new HibernateDAO();
		} 
		return instancia;
	}
	
	protected HibernateDAO()  {
		sf = HibernateFactory.getSessionFactory();
	}

	public Session getSession(){
		if(session == null || !session.isOpen()){
			session = sf.openSession();
			System.out.println("OPEN: " + session.isOpen());
		}
		return session;
	}
	
	public void closeSession(){
		if (session.isOpen()) {
			session.close();
			System.out.println("\nOPEN: " + session.isOpen());
		}
	}
	
	public void persist(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.persist(obj);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("rawtypes")
	public void persistList(List lista){
		Session session = getSession();
		session.beginTransaction();
		for(Object e : lista){
			session.persist(e);
		}
		session.flush();
		session.getTransaction().commit();
	}
	
	// Devuelve un objeto de tipo 'c' que contenga un Id 'o' que coincida.
	// Si no hay coincidencias, retorna null.
	@SuppressWarnings("rawtypes")
	public Object get (Class c, Object o) {
		Session session = getSession();
		return session.get(c, (Serializable) o);
	}
	
	public void delete(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
	}
	
	public void update(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
	}

	public void save(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
}
