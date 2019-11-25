package at.fhv.td;

import at.fhv.td.persistence.DBConnection;
import at.fhv.td.rmi.ClientSessionFactoryImpl;
import at.fhv.td.rmi.Setup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Lukas Bals
 */
public class Main implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DBConnection.setupDBConnection();
        Setup.setupRmiRegistry();
    }
}
