package com.maltsevve.crud4.model.builders.post;

import com.maltsevve.crud4.model.Post;

public class PostDirector {
    PostBuilder postBuilder;

    public void setPostBuilder(PostBuilder postBuilder) {
        this.postBuilder = postBuilder;
    }

    public Post buildPost() {
        postBuilder.buildPost();
        postBuilder.buildContent();
        return postBuilder.getPost();
    }
}
