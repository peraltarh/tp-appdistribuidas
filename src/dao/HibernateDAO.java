package dao;

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
		if (session.isOpen()) 
		{
			session.close();
			System.out.println("\nOPEN: " + session.isOpen());
		}
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


	public List<?> getListInt(String className, String columna,int value)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s. "+ columna + " =?").setInteger(0, value).list();

		return list;
	}
	
	public List<?> getListString(String className, String columna,String value)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s. "+ columna + " =?").setString(0, value).list();

		return list;
	}


	// Devuelve un objeto, en className recibe el nombre de la clase, campo es la columna y valor es el filtro.
	public Object getObjectWithString(String className, String campo, String value) {

		Session s = this.getSession();
		Object r = s.createQuery("from " + className + " s where s." + campo + " = ?").setString(0, value).uniqueResult();
		s.flush();
		return r;
	}

	public Object getObjectWithInt(String className, String campo, int value) {
		Session s = this.getSession();
		Object r = s.createQuery("from " + className + " s where s." + campo + " = ?").setInteger(0, value).uniqueResult();
	s.flush();
		return r;
	}

	public void delete(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		session.flush();
	}

	public void update(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		session.flush();
	}

	public Object save(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.flush();
		return obj;
	}
	public List<?> getList(String className)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className).list();

		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public Object get(Object clase, int id) {
		Session session = getSession();
		session.beginTransaction();
		Object obj = session.get((Class) clase, id);
		session.getTransaction().commit();
		session.flush();
		return obj;
	}
	
}
