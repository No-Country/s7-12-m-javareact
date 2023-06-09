package com.nocountry.backend.service.impl;

import org.springframework.stereotype.Service;

import com.nocountry.backend.model.dto.user.UserDto;
import com.nocountry.backend.model.mapper.IUserMapper;
import com.nocountry.backend.repository.IUserRepository;
import com.nocountry.backend.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    private final IUserMapper userMapper;

    @Override
    public UserDto findUserByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toUserDto)
                .orElseThrow(() -> new RuntimeException("Email user does not exist"));
    }

    @Override
    public Boolean emailExits(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
