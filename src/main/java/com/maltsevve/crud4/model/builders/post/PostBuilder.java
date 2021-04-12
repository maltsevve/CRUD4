package com.maltsevve.crud4.model.builders.post;

import com.maltsevve.crud4.model.Post;

public abstract class PostBuilder {
    Post post;

    public void buildPost() {
        post = new Post();
    }

    public void buildContent() {

    }

    public Post getPost() {
        return post;
    }
}
