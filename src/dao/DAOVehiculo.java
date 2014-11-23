package dao;

import dao.entities.VehiculoPersistencia;

public class DAOVehiculo
{
	static DAOVehiculo instance_ = null;
	
	public static DAOVehiculo getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOVehiculo();
        return instance_;
    }
	
	public VehiculoPersistencia persistirVehiculo(VehiculoPersistencia obj)
	{
		return (VehiculoPersistencia)HibernateDAO.getInstancia().save(obj);
	}
	
	public void update(VehiculoPersistencia obj)
	{
		HibernateDAO.getInstancia().update(obj);
	}
	
	public VehiculoPersistencia getVehiculo(String patente_)
	{
		return (VehiculoPersistencia) HibernateDAO.getInstancia().getObjectWithString("VehiculoPersistencia", "patente", patente_);
	}
}
