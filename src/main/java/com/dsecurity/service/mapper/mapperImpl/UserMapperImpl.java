package com.dsecurity.service.mapper.mapperImpl;

import com.dsecurity.entity.Role;
import com.dsecurity.entity.Users;
import com.dsecurity.service.dto.UserDTO;
import com.dsecurity.service.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Users toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        Users entity = new Users();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setStatus(dto.isStatus());
        entity.setFullName(dto.getFullName());
        entity.setPassword(dto.getPassword());
        entity.setAvatar(dto.getAvatar());
        entity.setPhone(dto.getPhone());

        return entity;
    }

    @Override
    public UserDTO toDto(Users entity) {
        if (entity == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setFullName(entity.getFullName());
        dto.setPassword(entity.getPassword());
        dto.setAvatar(entity.getAvatar());
        dto.setPhone(entity.getPhone());
        dto.setStatus(entity.isStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        Set<Role> roles = entity.getRoles();
        if (roles != null) {
            dto.setRolesId(roles.stream().map(Role::getId).collect(Collectors.toSet()));
        }
        return dto;
    }

    @Override
    public List<Users> toEntity(List<UserDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Users> entityList = new ArrayList<>();
        for (UserDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    @Override
    public List<UserDTO> toDto(List<Users> entityList) {
        if (entityList == null) {
            return null;
        }

        List<UserDTO> dtoList = new ArrayList<>();
        for (Users entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
