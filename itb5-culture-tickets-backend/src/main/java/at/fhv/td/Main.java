package at.fhv.td;

import at.fhv.td.communication.rmi.SetupRMI;
import at.fhv.td.persistence.DBConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Lukas Bals
 */
public class Main implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DBConnection.setupDBConnection();
        SetupRMI.setupRmiRegistry();
    }
}
