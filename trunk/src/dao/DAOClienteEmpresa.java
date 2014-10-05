package dao;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import clases.Empresa;
import persistencia.HibernateDAO;
import persistencia.HibernateFactory;

public class DAOClienteEmpresa
{
	static DAOClienteEmpresa instance_ = null;
	public static DAOClienteEmpresa getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOClienteEmpresa();
        return instance_;
    }
	
	public void persistir(Empresa empresa)
	{
		HibernateDAO.getInstancia().persist(empresa);
	}
	
	public Empresa getClienteEmpresa(String razonSocial_ , String Cuil_)
	{
		Session s = HibernateFactory.getSessionFactory().openSession();
		Empresa c = (Empresa) s.createCriteria(Empresa.class)
				.add(Restrictions.eq("CUIL_cliente_", Integer.parseInt(Cuil_)))
				.add(Restrictions.like("razon_social_", razonSocial_))
			.uniqueResult();
		s.close();
		return c;
	}
}
