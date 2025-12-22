    package com.bbt.blog.backend.business.concretes;

    import com.bbt.blog.backend.business.abstracts.PostService;
    import com.bbt.blog.backend.dataAccess.abstracts.PostDao;
    import com.bbt.blog.backend.entity.concretes.Post;
    import org.springframework.stereotype.Service;
    import java.time.LocalDateTime;
    import java.util.List;

    @Service
    public class PostManager implements PostService {

        private final PostDao postDao;

        public PostManager(PostDao postdao) {
            this.postDao = postdao;
        }

        @Override
        public List<Post> getAllPosts() {
            return postDao.findAll();
        }

        @Override
        public Post getPostById(Long id) {
            return postDao.findById(id).orElse(null);
        }

        @Override
        public Post savePost(Post post) {
            post.setCreatedAt(LocalDateTime.now());
            return postDao.save(post);
        }


        @Override
        public void deletePost(Long id) {
            // postu sadece admin silebilir
            postDao.deleteById(id);
        }

    }
