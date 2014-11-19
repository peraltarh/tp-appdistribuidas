package dao;

import java.util.List;

import clases.Pedido;
import dao.entities.DepositoPersistencia;
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
		List<PedidoPersistencia> lista = (List<PedidoPersistencia>) HibernateDAO.getInstancia().getListString("PedidoPersistencia", "estado", estado);

		return lista;
	}

	public PedidoPersistencia getPedidoPorEstado(int numeroPedido) {
 		return (PedidoPersistencia)HibernateDAO.getInstancia().getObjectWithInt("PedidoPersistencia", "idPedido", numeroPedido);
	}
	
	public List<PedidoPersistencia> getPedidos()
	{
		List<PedidoPersistencia> lista = (List<PedidoPersistencia>) HibernateDAO.getInstancia().getList("PedidoPersistencia");

		return lista;
	}
}
