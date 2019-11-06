package at.fhv.td.domain.assembler;

import at.fhv.td.domain.interfaces.IClient;
import at.fhv.td.dto.ClientDTO;
import at.fhv.td.rmi.interfaces.IClientDTO;

import java.rmi.RemoteException;

public class ClientAssembler {
    private ClientAssembler() {
    }

    public static IClientDTO toClientDTO(IClient client) {
        Long clientID = client.getClientId();
        String firstname = client.getFirstname();
        String lastname = client.getLastname();
        String address = client.getAddress();

        ClientDTO newDto = null;
        try {
            newDto = new ClientDTO();
            newDto.setId(clientID);
            newDto.setFirstName(firstname);
            newDto.setLastName(lastname);
            newDto.setAddress(address);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return newDto;
    }
}
