package com.example.toyshop.mapper;

import com.example.toyshop.dto.user.UserCreateDTO;
import com.example.toyshop.dto.user.UserDTO;
import com.example.toyshop.dto.user.UserDetailDTO;
import com.example.toyshop.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDetailDto(UserDetailDTO userDetailDTO);

    UserDetailDTO toDetailDto(User user);

    UserDTO toDto(User user);

    User fromDto(UserDTO dto);

    User fromCreateDto(UserCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User update(UserCreateDTO userDetailDto, @MappingTarget User user);
}
