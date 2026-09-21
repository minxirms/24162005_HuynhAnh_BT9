package vn.minxi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.minxi.dto.UserDTO;
import vn.minxi.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	@Mapping(target = "roleName", source = "role.name")
	UserDTO toDTO(User user);
}
