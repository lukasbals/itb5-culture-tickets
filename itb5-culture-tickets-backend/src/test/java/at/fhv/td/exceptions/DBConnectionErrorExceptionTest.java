package at.fhv.td.exceptions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DBConnectionErrorExceptionTest {

    private DBConnectionErrorException _testDBConnectionErrorException;

    @Before
    public void before() {
        _testDBConnectionErrorException = new DBConnectionErrorException();
    }

    @Test
    public void getTitle() {
        assertEquals("DB connection error", _testDBConnectionErrorException.getTitle());
    }

    @Test
    public void getMessage() {
        assertEquals("Failed to connect to the database", _testDBConnectionErrorException.getMessage());
    }
}