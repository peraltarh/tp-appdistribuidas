package dao;

import org.hibernate.classic.Session;

import clases.controller.Sistema;


public class DAOsistema
{
	static DAOsistema instance_ = null;
	public static DAOsistema getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOsistema();
        return instance_;
    }
	
	public void persistir(Sistema sistema)
	{
		HibernateDAO.getInstancia().persist(sistema);
	}

	public Sistema getSistema(String codigo_SKF_, String codigo_extendido_)
	{
		Session s =HibernateFactory.getSessionFactory().openSession();
		Sistema r = (Sistema) s.createCriteria(Sistema.class)
			.uniqueResult();
		s.close();
		return r;
	}
}
