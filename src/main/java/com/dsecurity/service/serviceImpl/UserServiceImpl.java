package com.dsecurity.service.serviceImpl;

import com.dsecurity.entity.Role;
import com.dsecurity.entity.Users;
import com.dsecurity.entity.enumeration.RoleName;
import com.dsecurity.repository.RoleRepository;
import com.dsecurity.repository.UserRepository;
import com.dsecurity.security.jwt.JwtProvider;
import com.dsecurity.service.UserService;
import com.dsecurity.service.dto.UserDTO;
import com.dsecurity.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final JwtProvider jwtProvider;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        Users users = userMapper.toEntity(userDTO);
        users = userRepository.save(users);
        return userMapper.toDto(users);
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        Page<Users> usersPage = userRepository.findAll(pageable);
        return usersPage.map(userMapper::toDto);
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return userRepository.findById(id).map(userMapper :: toDto);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }
    @Override
    public Users registerUser(UserDTO userDTO, String password) {
        // Kiểm tra xem người dùng có tồn tại trong hệ thống hay không
        Optional<Users> existingUser = userRepository.findByUsername(userDTO.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("User with username " + userDTO.getUsername() + " already exists.");
        }
        Users newUser = new Users();
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(encryptedPassword);
        newUser.setFullName(userDTO.getFullName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setAvatar(userDTO.getAvatar());
        newUser.setPhone(userDTO.getPhone());
        //user đang để auto kích hoạt, có thể thay đổi
        newUser.setStatus(true);
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());
        //role đang để mac định là teacher , có thể thay đổi
        Optional<Role> defaultRole = roleRepository.findByRoleName(RoleName.TEACHER); // Thay đổi tên vai trò mặc định nếu cần
        Set<Role> authorities = new HashSet<>();
        defaultRole.ifPresent(authorities::add);
        newUser.setRoles(authorities);
        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }
}
