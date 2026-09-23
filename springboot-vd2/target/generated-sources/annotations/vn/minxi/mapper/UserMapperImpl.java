package vn.minxi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.minxi.dto.UserDTO;
import vn.minxi.entity.Role;
import vn.minxi.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-21T15:36:47+0700",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.roleName( userRoleName( user ) );
        userDTO.email( user.getEmail() );
        userDTO.enabled( user.isEnabled() );
        userDTO.fullName( user.getFullName() );
        userDTO.id( user.getId() );
        userDTO.images( user.getImages() );
        userDTO.username( user.getUsername() );

        return userDTO.build();
    }

    private String userRoleName(User user) {
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getName();
    }
}
