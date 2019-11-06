package at.fhv.td.domain.assembler;

import at.fhv.td.domain.TicketAnswer;
import at.fhv.td.dto.TicketAnswerDTO;
import at.fhv.td.dto.TicketDTO;

import java.rmi.RemoteException;

public class TicketAnswerAssembler {
    private TicketAnswerAssembler() {
    }

    public static TicketAnswerDTO toTicketAnswerDTO(TicketAnswer answer) {
        try {
            TicketAnswerDTO newTicketAnswerDto = new TicketAnswerDTO();
            newTicketAnswerDto.setTickets(answer.getTickets().stream().map(TicketAssembler::toTicketDTO).toArray(TicketDTO[]::new));
            newTicketAnswerDto.setMessage(answer.getMessage());
            return newTicketAnswerDto;
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }
}
