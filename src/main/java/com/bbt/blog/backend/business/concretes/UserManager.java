package com.bbt.blog.backend.business.concretes;

import com.bbt.blog.backend.business.abstracts.UserService;
import com.bbt.blog.backend.dataAccess.abstracts.UserDao;
import com.bbt.blog.backend.entity.concretes.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserManager(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        if (user.getRole() == null || (!user.getRole().equals("ADMIN") && !user.getRole().equals("USER"))) {
            user.setRole("USER");
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userDao.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
