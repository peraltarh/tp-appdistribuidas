package dao;
import java.util.List;


import dao.entities.*;


public class DAODeposito
{
	static DAODeposito instance_ = null;
	
	public static DAODeposito getInstance()
    {
		if(instance_ == null)
			instance_ = new DAODeposito();
        return instance_;
    }
	
	public void persistirDeposito(DepositoPersistencia obj)
	{
		HibernateDAO.getInstancia().save(obj);
		
	}
	
	
	public void update(DepositoPersistencia obj)
	{
		HibernateDAO.getInstancia().update(obj);
	}
	
	
	
		
	@SuppressWarnings("unchecked")
	public List<DepositoPersistencia> getDepositos(int idSucursal)
	{
		List<DepositoPersistencia> lista = (List<DepositoPersistencia>) HibernateDAO.getInstancia().getListInt("DepositoPersistencia", "suc", idSucursal);
		return lista;
	}
	
}
