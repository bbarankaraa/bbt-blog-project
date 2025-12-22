package com.bbt.blog.backend.business.abstracts;

import com.bbt.blog.backend.entity.concretes.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post savePost(Post post);
    void deletePost(Long id);
}
