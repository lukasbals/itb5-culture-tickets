package at.fhv.td.dto.dtoInterfaces;

import at.fhv.td.dto.RoleDTO;
import at.fhv.td.dto.UserDTO;

import java.util.List;

public interface IHasRole {

    Long getHasRoleId();

    List<RoleDTO> getRoles();

    List<UserDTO> getUsers();
}
