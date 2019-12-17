package at.fhv.td.domain.assembler;

import at.fhv.td.communication.dto.ClientDTO;
import at.fhv.td.domain.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class ClientAssemblerTest {
    private ClientDTO _expected;
    @Mock
    private Client _client;
    private String _fname = "Patrick";
    private String _lname = "Poiger";
    private String _address = "Zuhause 1";
    private Long _id = 1l;

    @Before
    public void before() throws RemoteException {
        _expected = new ClientDTO();
        _expected.setFirstName(_fname);
        _expected.setLastName(_lname);
        _expected.setAddress(_address);
        _expected.setId(_id);

        when(_client.getFirstname()).thenReturn(_fname);
        when(_client.getLastname()).thenReturn(_lname);
        when(_client.getAddress()).thenReturn(_address);
        when(_client.getId()).thenReturn(_id);
    }

    @Test
    public void toClientDTO() {
        assertEquals(_expected, ClientAssembler.toClientDTO(_client));
    }
}