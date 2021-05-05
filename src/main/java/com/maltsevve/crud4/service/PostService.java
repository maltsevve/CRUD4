package com.maltsevve.crud4.service;

import com.maltsevve.crud4.model.Post;
import com.maltsevve.crud4.repository.JavaIOPostRepositoryImpl;
import com.maltsevve.crud4.repository.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository = new JavaIOPostRepositoryImpl();

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post update(Post post) {
        return postRepository.update(post);
    }

    public Post getById(Long aLong) {
        return postRepository.getById(aLong);
    }

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public void deleteById(Long aLong) {
        postRepository.deleteById(aLong);
    }
}
