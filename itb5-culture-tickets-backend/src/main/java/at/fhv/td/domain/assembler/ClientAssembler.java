package at.fhv.td.domain.assembler;

import at.fhv.td.communication.dto.ClientDTO;
import at.fhv.td.domain.interfaces.IClient;

public class ClientAssembler {
    private ClientAssembler() {
    }

    public static ClientDTO toClientDTO(IClient client) {
        Long clientID = client.getId();
        String firstname = client.getFirstname();
        String lastname = client.getLastname();
        String address = client.getAddress();

        ClientDTO newDto = null;
        newDto = new ClientDTO();
        newDto.setId(clientID);
        newDto.setFirstName(firstname);
        newDto.setLastName(lastname);
        newDto.setAddress(address);
        return newDto;
    }
}
