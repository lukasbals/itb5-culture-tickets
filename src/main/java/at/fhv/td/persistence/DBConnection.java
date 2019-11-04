package at.fhv.td.persistence;

import at.fhv.td.exceptions.DBConnectionErrorException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.ServiceException;

/**
 * @author Lukas Bals
 */
public class DBConnection extends Thread {
    private static SessionFactory _sessionFactory = null;
    private static String[] _hibernateClasses = {
            "at.fhv.td.domain.Client",
    };

    @Override
    public void run() {
        while (_sessionFactory == null) {
            try {
                _sessionFactory = createSessionFactory();
                System.out.println("Connected!");
            } catch (ServiceException e) {
                System.err.println(e.getMessage());
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

        }
    }

    private DBConnection() {
    }

    static void setSessionFactory(SessionFactory sessionFactory) {
        _sessionFactory = sessionFactory;
    }

    public static void setupDBConnection() {
        DBConnection dbConnection = new DBConnection();
        dbConnection.start();
    }

    public static Session getSession() throws DBConnectionErrorException {
        if (_sessionFactory == null) {
            throw new DBConnectionErrorException();
        }
        if (_sessionFactory.getCurrentSession().isOpen()) {
            return _sessionFactory.getCurrentSession();
        }
        return _sessionFactory.openSession();
    }

    public static boolean connected() {
        return _sessionFactory != null;
    }

    private SessionFactory createSessionFactory() throws ServiceException {
        Configuration configuration = getConfiguration();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()
        ).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        try {
            for (String className : _hibernateClasses) {
                configuration.addAnnotatedClass(Class.forName(className));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return configuration;
    }
}
