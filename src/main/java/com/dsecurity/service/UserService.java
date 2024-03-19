package com.dsecurity.service;

import com.dsecurity.entity.Users;
import com.dsecurity.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    Page<UserDTO> findAll(Pageable pageable);

    Optional<UserDTO> findOne(Long id);

    void delete(Long id);

    List<UserDTO> getAll();

    Users registerUser(UserDTO userDTO, String password);

}
