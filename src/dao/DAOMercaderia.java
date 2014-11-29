package dao;

import dao.entities.*;


public class DAOMercaderia 
{
	static DAOMercaderia instance_ = null;
	
	public static DAOMercaderia getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOMercaderia();
        return instance_;
    }
	
	public MercaderiaPorPesoPersistencia persistirMercaderiaPorPeso(MercaderiaPorPesoPersistencia mp)
	{
		return (MercaderiaPorPesoPersistencia)HibernateDAO.getInstancia().save(mp);
		
	}
	
	public MercaderiaPorVolumenPersistencia persistirParticular(MercaderiaPorVolumenPersistencia mp)
	{
		return (MercaderiaPorVolumenPersistencia)HibernateDAO.getInstancia().save(mp);
	}
	
	public void update(MercaderiaPorPesoPersistencia particular)
	{
		HibernateDAO.getInstancia().update(particular);
	}
	
	public void update(MercaderiaPorVolumenPersistencia empresa)
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
	
	public MercaderiaPorPesoPersistencia getMercaderiaPorPeso(int idMercaderia)
	{
		MercaderiaPorPesoPersistencia mp = (MercaderiaPorPesoPersistencia) HibernateDAO.getInstancia().getObjectWithInt("MercaderiaPersistencia", "idMercaderia", idMercaderia);
		return mp;
	}
	
	public MercaderiaPorVolumenPersistencia getMercaderiaPorVolumen(int idMercaderia)
	{
		MercaderiaPorVolumenPersistencia mp = (MercaderiaPorVolumenPersistencia) HibernateDAO.getInstancia().getObjectWithInt("MercaderiaPersistencia", "idMercaderia", idMercaderia);
		return mp;
	}

	
}
