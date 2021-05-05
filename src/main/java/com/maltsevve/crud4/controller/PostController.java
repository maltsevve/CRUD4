package com.maltsevve.crud4.controller;

import com.maltsevve.crud4.model.Post;
import com.maltsevve.crud4.service.PostService;

import java.util.List;

public class PostController {
    PostService postService = new PostService();

    public Post save(Post post) {
        return postService.save(post);
    }

    public Post update(Post post) {
        return postService.update(post);
    }

    public Post getById(Long aLong) {
        return postService.getById(aLong);
    }

    public List<Post> getAll() {
        return postService.getAll();
    }

    public void deleteById(Long aLong) {
        postService.deleteById(aLong);
    }
}
