package com.bbt.blog.backend.dataAccess.abstracts;

import com.bbt.blog.backend.entity.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
