package com.service.impl;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.repository.UserJpaRepository;
import com.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserJpaRepository userJpaRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserJpaRepository userJpaRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        String securePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(securePassword);
        userJpaRepository.saveAndFlush(user);
    }

    public List<User> getAllUsers() {
        return userJpaRepository.findAll();
    }

    public void deleteUser(User user) {
        userJpaRepository.delete(user);
    }

    public Optional<User> getById(Long userId) {
        User user = userJpaRepository.getOne(userId);
        return Optional.ofNullable(user);
    }

    public Optional<User> getByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    public void updateUser(User user) {
        String securePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(securePassword);
        userJpaRepository.saveAndFlush(user);
    }

}
