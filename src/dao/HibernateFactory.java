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
        	 config.addAnnotatedClass(AreaPersistencia.class);
        	 config.addAnnotatedClass(CarrierPersistencia.class);
        	 config.addAnnotatedClass(ClientePersistencia.class);
        	 config.addAnnotatedClass(ConsideracionEspecialPersistencia.class);
        	 config.addAnnotatedClass(CuentaCorrientePersistencia.class);
        	 config.addAnnotatedClass(DepositoPersistencia.class);
        	 config.addAnnotatedClass(DestinatarioPersistencia.class);
        	 config.addAnnotatedClass(EmpresaPersistencia.class);
        	 config.addAnnotatedClass(FacturaPersistencia.class);
        	 config.addAnnotatedClass(ItemFacturaPersistencia.class);
        	 config.addAnnotatedClass(MantenimientoRealizadoPersistencia.class);
        	 config.addAnnotatedClass(MapaDeRutaPersistencia.class);
        	 config.addAnnotatedClass(MercaderiaPersistencia.class);
        	 config.addAnnotatedClass(MercaderiaPorPesoPersistencia.class);
        	 config.addAnnotatedClass(MercaderiaPorVolumenPersistencia.class);
        	 config.addAnnotatedClass(MovimientoPersistencia.class);
        	 config.addAnnotatedClass(MovimientoCuentaPersistencia.class);
        	 config.addAnnotatedClass(ParticularPersistencia.class);
        	 config.addAnnotatedClass(EmpresaDirValidasPersistencia.class);
        	 config.addAnnotatedClass(PedidoPersistencia.class);
        	 config.addAnnotatedClass(PlanDeMantenimientoPersistencia.class);
        	 config.addAnnotatedClass(ProductoPersistencia.class);
        	 config.addAnnotatedClass(RemitoPersistencia.class);
        	 config.addAnnotatedClass(SucursalPersistencia.class);
        	 config.addAnnotatedClass(VehiculoPersistencia.class);
        	 config.addAnnotatedClass(VehiculoExternoPersistencia.class); 
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
