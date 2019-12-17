package at.fhv.td.persistence;

import at.fhv.td.exceptions.DBConnectionErrorException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class DBConnectionTest {
    @Mock
    Session _session;
    @Mock
    SessionFactory _sessionFactory;

    @Before
    public void before() {
        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void getSessionWithSessionFactoryWithOpenSession() throws DBConnectionErrorException {
        DBConnection.setSessionFactory(_sessionFactory);
        when(_session.isOpen()).thenReturn(true);
        assertEquals(_session, DBConnection.getSession());
    }

    @Test
    public void getSessionWithSessionFactoryWithClosedSession() throws DBConnectionErrorException {
        DBConnection.setSessionFactory(_sessionFactory);
        when(_session.isOpen()).thenReturn(false);
        when(_sessionFactory.openSession()).thenReturn(_session);
        assertEquals(_session, DBConnection.getSession());
    }

    @Test
    public void connected() {
        DBConnection.setSessionFactory(null);
        assertFalse(DBConnection.connected());
        DBConnection.setSessionFactory(_sessionFactory);
        assertTrue(DBConnection.connected());
    }
}