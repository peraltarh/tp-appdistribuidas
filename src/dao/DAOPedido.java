package dao;

import java.util.List;



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
	
	public PedidoPersistencia persistir(PedidoPersistencia pedido) 
	{
		return (PedidoPersistencia)HibernateDAO.getInstancia().save(pedido);
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoPersistencia> getPedidosPorEstado(String estado)
	{
		List<PedidoPersistencia> lista = (List<PedidoPersistencia>) HibernateDAO.getInstancia().getListString("PedidoPersistencia", "estado", estado);

		return lista;
	}

	public PedidoPersistencia getPedidoPorEstado(int numeroPedido) {
 		return (PedidoPersistencia)HibernateDAO.getInstancia().getObjectWithInt("PedidoPersistencia", "idPedido", numeroPedido);
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoPersistencia> getPedidos()
	{
		List<PedidoPersistencia> lista = (List<PedidoPersistencia>) HibernateDAO.getInstancia().getList("PedidoPersistencia");

		return lista;
	}
	
	public PedidoPersistencia update(PedidoPersistencia pedido) 
	{
		return (PedidoPersistencia) HibernateDAO.getInstancia().update(pedido);
	}

	public PedidoPersistencia getPedido(int idPedido) {
		return (PedidoPersistencia) HibernateDAO.getInstancia().get(PedidoPersistencia.class, idPedido);
	}

	@SuppressWarnings("unchecked")
	public List<PedidoPersistencia> getPedidosPorCliente(int idCliente) {
 		return (List<PedidoPersistencia>)HibernateDAO.getInstancia().getListInt("PedidoPersistencia", "cliente", idCliente);
	}
}
