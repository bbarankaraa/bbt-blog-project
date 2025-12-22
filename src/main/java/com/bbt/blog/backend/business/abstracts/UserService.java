package com.bbt.blog.backend.business.abstracts;

import com.bbt.blog.backend.entity.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User getByUsername(String username);
}
