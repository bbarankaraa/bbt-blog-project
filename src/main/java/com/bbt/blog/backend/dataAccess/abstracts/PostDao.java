package com.bbt.blog.backend.dataAccess.abstracts;

import com.bbt.blog.backend.entity.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post,Long> {
}
