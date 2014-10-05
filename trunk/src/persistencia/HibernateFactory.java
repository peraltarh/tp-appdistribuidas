package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import controller.Sistema;
import clases.*;

 
public class HibernateFactory
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(Sistema.class);
        	 config.addAnnotatedClass(Area.class);
        	 config.addAnnotatedClass(Armas.class);
        	 config.addAnnotatedClass(Carrier.class);
        	 config.addAnnotatedClass(Cliente.class);
        	 config.addAnnotatedClass(Combustibles.class);
        	 config.addAnnotatedClass(ConsideracionEspecial.class);
        	 config.addAnnotatedClass(CuentaCorriente.class);
        	 config.addAnnotatedClass(Deposito.class);
        	 config.addAnnotatedClass(Destinatario.class);
        	 config.addAnnotatedClass(Empresa.class);
        	 config.addAnnotatedClass(EmpresaSubContratada.class);
        	 config.addAnnotatedClass(Explosivos.class);
        	 config.addAnnotatedClass(Factura.class);
        	 config.addAnnotatedClass(ItemFactura.class);
        	 config.addAnnotatedClass(MantenimientoRealizado.class);
        	 config.addAnnotatedClass(MapaDeRuta.class);
        	 config.addAnnotatedClass(Mercaderia.class);
        	 config.addAnnotatedClass(MercaderiaPorPeso.class);
        	 config.addAnnotatedClass(MercaderiaPorVolumen.class);
        	 config.addAnnotatedClass(Movimiento.class);
        	 config.addAnnotatedClass(MovimientoCuenta.class);
        	 config.addAnnotatedClass(Particular.class);
        	 config.addAnnotatedClass(Pedido.class);
        	 config.addAnnotatedClass(PlanDeMantenimiento.class); 
        	 config.addAnnotatedClass(PoliticasDeEnvio.class);
        	 config.addAnnotatedClass(PorGranel.class); 
        	 config.addAnnotatedClass(Producto.class);
        	 config.addAnnotatedClass(QuimicosToxicos.class);
        	 config.addAnnotatedClass(Remito.class);
        	 config.addAnnotatedClass(Sucursal.class);
        	 config.addAnnotatedClass(Vehiculo.class);
        	 config.addAnnotatedClass(VehiculoExterno.class); 
           	 sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
