package dao;

import clases.Pedido;
import dao.entities.PedidoPersistencia;

public class DAOPedido 
{
	static DAOPedido instance_ = null;
	public static DAOPedido getInstance()
    {
		if(instance_ == null)
			instance_ = new DAOPedido();
        return instance_;
    }
	
	public void persistir(Pedido _pedido) 
	{
		HibernateDAO.getInstancia().save(_pedido);
	}
	
	public PedidoPersistencia getPedidoPorEstado(String estado)
	{
		return (PedidoPersistencia)HibernateDAO.getInstancia().getObjectWithString("PedidoPersistencia", "estado", estado);
	}
}
