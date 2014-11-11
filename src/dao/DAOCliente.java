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
	
	public void persistirEmpresa(EmpresaPersistencia empresa)
	{
		HibernateDAO.getInstancia().save(empresa);
		
	}
	
	public void persistirParticular(ParticularPersistencia particular)
	{
		HibernateDAO.getInstancia().save(particular);
	}
	
	public void update(ParticularPersistencia particular)
	{
		HibernateDAO.getInstancia().update(particular);
	}
	
	public void update(EmpresaPersistencia empresa)
	{
		HibernateDAO.getInstancia().update(empresa);
	}
	
	
//	public EmpresaPersistencia getClienteEmpresa(String razonSocial , String Cuil)
//	{
//		Session s = HibernateFactory.getSessionFactory().openSession();
//		EmpresaPersistencia c = (EmpresaPersistencia) s.createCriteria(EmpresaPersistencia.class)
//				.add(Restrictions.eq("CUIL_cliente_", Integer.parseInt(Cuil)))
//				.add(Restrictions.like("razon_social_", razonSocial))
//			.uniqueResult();
//		s.close();
//		return c;
//	}
	
	public ParticularPersistencia getClienteParticular(String dni)
	{
		ParticularPersistencia c = (ParticularPersistencia) HibernateDAO.getInstancia().getObjectWithString("ClientePersistencia", "dni", dni);
		return c;
	}
	
	public EmpresaPersistencia getClienteEmpresa(String cuit)
	{
		EmpresaPersistencia c = (EmpresaPersistencia) HibernateDAO.getInstancia().getObjectWithString("ClientePersistencia", "cuit", cuit);
		return c;
	}

	
}
