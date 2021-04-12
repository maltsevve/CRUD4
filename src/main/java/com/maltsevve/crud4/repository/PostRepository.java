package com.maltsevve.crud4.repository;

import com.maltsevve.crud4.model.Post;

import java.util.List;

public interface PostRepository extends GenericRepository<Post, Long>{
    @Override
    Post save(Post post);

    @Override
    Post update(Post post);

    @Override
    Post getById(Long aLong);

    @Override
    List<Post> getAll();

    @Override
    void deleteById(Long aLong);
}
