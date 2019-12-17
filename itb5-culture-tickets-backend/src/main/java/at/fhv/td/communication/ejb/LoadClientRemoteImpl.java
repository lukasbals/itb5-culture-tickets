package at.fhv.td.communication.ejb;

import at.fhv.td.application.ClientController;
import at.fhv.td.communication.dto.ClientDTO;
import at.fhv.td.domain.assembler.ClientAssembler;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class LoadClientRemoteImpl implements ILoadClientRemote {
    @Override
    public List<ClientDTO> loadClients() {
        return ClientController.getClients().stream().map(ClientAssembler::toClientDTO).collect(Collectors.toList());
    }
}
