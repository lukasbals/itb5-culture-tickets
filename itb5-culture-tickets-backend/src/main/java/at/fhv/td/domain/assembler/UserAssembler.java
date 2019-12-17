package at.fhv.td.domain.assembler;

import at.fhv.td.communication.dto.UserDTO;
import at.fhv.td.domain.Role;
import at.fhv.td.domain.interfaces.IUser;

import java.util.List;
import java.util.stream.Collectors;

public class UserAssembler {
    private UserAssembler() {
    }

    public static UserDTO toUserDTO(IUser user) {
        long userId = user.getId();
        String userName = user.getUsername();
        List<String> roles = user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList());

        UserDTO newDto = new UserDTO();
        newDto.setUserId(userId);
        newDto.setUserName(userName);
        newDto.setRoles(roles);
        return newDto;
    }
}
