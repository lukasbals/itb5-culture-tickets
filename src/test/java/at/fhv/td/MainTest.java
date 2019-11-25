package at.fhv.td;

import at.fhv.td.persistence.DBConnection;
import at.fhv.td.rmi.Setup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.ServletContextEvent;

import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DBConnection.class, Setup.class})
public class MainTest {
    @Mock
    ServletContextEvent _servletContextEvent;

    @Before
    public void before() {
        mockStatic(DBConnection.class);
        mockStatic(Setup.class);
    }

    @Test
    public void contextInitialized() {
        Main main = new Main();
        main.contextInitialized(_servletContextEvent);
        verifyStatic(DBConnection.class, times(1));
        DBConnection.setupDBConnection();
        verifyStatic(Setup.class, times(1));
        Setup.setupRmiRegistry();
    }
}