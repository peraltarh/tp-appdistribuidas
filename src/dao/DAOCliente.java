package dao;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import dao.entities.*;


public class DAOCliente
{
	static DAOCliente instance_ = null;
	public static DAOCliente getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOCliente();
        return instance_;
    }
	
	public void persistir(Empresa empresa)
	{
		HibernateDAO.getInstancia().save(empresa);
	}
	
	public void persistir(Particular particular)
	{
		HibernateDAO.getInstancia().save(particular);
	}
	
	
//	public Empresa getClienteEmpresa(String razonSocial , String Cuil)
//	{
//		Session s = HibernateFactory.getSessionFactory().openSession();
//		Empresa c = (Empresa) s.createCriteria(Empresa.class)
//				.add(Restrictions.eq("CUIL_cliente_", Integer.parseInt(Cuil)))
//				.add(Restrictions.like("razon_social_", razonSocial))
//			.uniqueResult();
//		s.close();
//		return c;
//	}
//	
	
}
