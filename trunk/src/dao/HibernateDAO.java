package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.entities.DepositoPersistencia;


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

	@SuppressWarnings("unchecked")
	public List<?> getList(String className, String columna,int value)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s. "+ columna + " =?").setInteger(0, value).list();

		return list;
	}


	// Devuelve un objeto, en className recibe el nombre de la clase, campo es la columna y valor es el filtro.
	public Object getObjectWithString(String className, String campo, String value) {

		Session s = this.getSession();
		Object r = s.createQuery("from " + className + " s where s." + campo + " = ?").setString(0, value).uniqueResult();

		return r;
	}

	public Object getObjectWithInt(String className, String campo, int value) {
		Session s = this.getSession();
		Object r = s.createQuery("from " + className + " s where s." + campo + " = ?").setInteger(0, value).uniqueResult();
		return r;
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
