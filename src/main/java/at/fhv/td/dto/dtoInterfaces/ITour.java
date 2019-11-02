package at.fhv.td.dto.dtoInterfaces;

import at.fhv.td.dto.UserDTO;

public interface ITour {
    Long getTourId();

    String getDescription();

    String getCategory();

    UserDTO getUsername();
}
