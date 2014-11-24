package dao;

import java.util.List;

import dao.entities.*;


public class DAOSucursal 
{
	static DAOSucursal instance_ = null;
	
	public static DAOSucursal getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOSucursal();
        return instance_;
    }
	
	public SucursalPersistencia persistirSucursal(SucursalPersistencia obj)
	{
		return (SucursalPersistencia)HibernateDAO.getInstancia().save(obj);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SucursalPersistencia> getListSucursales(){
		List<SucursalPersistencia> listaT = null;
		listaT = (List<SucursalPersistencia>) HibernateDAO.getInstancia().getList("SucursalPersistencia");
		return listaT;
	}
	
	
	public void update(SucursalPersistencia obj)
	{
		HibernateDAO.getInstancia().update(obj);
	}
	
	public SucursalPersistencia getSucursal(String nombre)
	{
		SucursalPersistencia obj = (SucursalPersistencia) HibernateDAO.getInstancia().getObjectWithString("SucursalPersistencia", "nombre", nombre);
		return obj;
	}
}
