package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import dao.entities.*;


 
public class HibernateFactory
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
//        	 config.addAnnotatedClass(Sistema.class);
//        	 config.addAnnotatedClass(Area.class);
//        	 config.addAnnotatedClass(Armas.class);
//        	 config.addAnnotatedClass(Carrier.class);
        	 config.addAnnotatedClass(ClientePersistencia.class);
//        	 config.addAnnotatedClass(Combustibles.class);
//        	 config.addAnnotatedClass(ConsideracionEspecial.class);
        	 config.addAnnotatedClass(CuentaCorrientePersistencia.class);
        	 config.addAnnotatedClass(DepositoPersistencia.class);
//        	 config.addAnnotatedClass(Destinatario.class);
        	 config.addAnnotatedClass(EmpresaPersistencia.class);
//        	 config.addAnnotatedClass(EmpresaSubContratada.class);
//        	 config.addAnnotatedClass(Explosivos.class);
//        	 config.addAnnotatedClass(Factura.class);
//        	 config.addAnnotatedClass(ItemFactura.class);
//        	 config.addAnnotatedClass(MantenimientoRealizado.class);
        	 config.addAnnotatedClass(MapaDeRutaPersistencia.class);
//        	 config.addAnnotatedClass(Mercaderia.class);
//        	 config.addAnnotatedClass(MercaderiaPorPeso.class);
//        	 config.addAnnotatedClass(MercaderiaPorVolumen.class);
//        	 config.addAnnotatedClass(Movimiento.class);
        	 config.addAnnotatedClass(MovimientoCuentaPersistencia.class);
        	 config.addAnnotatedClass(ParticularPersistencia.class);
        	 config.addAnnotatedClass(EmpresaDirValidasPersistencia.class);
        	 config.addAnnotatedClass(PedidoPersistencia.class);
//        	 config.addAnnotatedClass(PlanDeMantenimiento.class); 
//        	 config.addAnnotatedClass(PoliticasDeEnvio.class);
//        	 config.addAnnotatedClass(PorGranel.class); 
        	 config.addAnnotatedClass(ProductoPersistencia.class);
//        	 config.addAnnotatedClass(QuimicosToxicos.class);
//        	 config.addAnnotatedClass(Remito.class);
        	 config.addAnnotatedClass(SucursalPersistencia.class);
        	 config.addAnnotatedClass(VehiculoPersistencia.class);
//        	 config.addAnnotatedClass(VehiculoExterno.class); 
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
