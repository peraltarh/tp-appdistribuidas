package dao;
import org.hibernate.*;

import dao.entities.*;


public class DAOCuentaCorriente
{
	static DAOCuentaCorriente instance_ = null;
	public static DAOCuentaCorriente getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOCuentaCorriente();
        return instance_;
    }
	
	public void persistir(CuentaCorrientePersistencia cuenta)
	{
		HibernateDAO.getInstancia().save(cuenta);
	}
	
	public void update(CuentaCorrientePersistencia cuenta)
	{
		HibernateDAO.getInstancia().update(cuenta);
	}
	
	
	public CuentaCorrientePersistencia getCuentaCorriente(int cbu)
	{
		Session s = HibernateFactory.getSessionFactory().openSession();
		CuentaCorrientePersistencia c = (CuentaCorrientePersistencia) HibernateDAO.getInstancia().getObjectWithInt("CuentaCorrientePersistencia", "cbu", cbu);
		s.close();
		return c;
	}
	
}
