package com.example.toyshop.service;

import com.example.toyshop.dto.user.UserCreateDTO;
import com.example.toyshop.dto.user.UserDTO;
import com.example.toyshop.dto.user.UserDetailDTO;
import com.example.toyshop.entity.User;
import com.example.toyshop.security.Role;
import com.example.toyshop.security.Status;
import com.example.toyshop.repository.UserRepository;
import com.example.toyshop.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    public UserDetailDTO create(UserCreateDTO dto) {
        return mapper.toDetailDto(repository.save(mapper.fromCreateDto(dto)));
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User save(UserCreateDTO userDTO) {
        var user = mapper.fromCreateDto(userDTO);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        if (userDTO.getRole() == null){
            user.setRole(Role.USER);
        }else{
            user.setRole(Role.valueOf(userDTO.getRole()));
        }
        return save(user);
    }

    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public User getByEmail(String username) {
        return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserDetailDTO findByIdDto(Long id) {
        return mapper.toDetailDto(repository.findById(id).orElse(null));
    }

    public UserDetailDTO update(Long id, UserCreateDTO dto) {
        var user = repository.findById(id).orElse(null);
        if (user != null)
            return mapper.toDetailDto(repository.save(mapper.update(dto, user)));
        return null;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
