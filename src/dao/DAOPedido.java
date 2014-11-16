package dao;

import java.util.List;

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
	
	public void persistir(PedidoPersistencia pedido) 
	{
		HibernateDAO.getInstancia().save(pedido);
	}
	
	public List<PedidoPersistencia> getPedidosPorEstado(String estado)
	{
		return (List<PedidoPersistencia>) HibernateDAO.getInstancia().getListString("PedidoPersistencia", "estado", estado);
	}
}
