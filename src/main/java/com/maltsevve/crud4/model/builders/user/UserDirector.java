package com.maltsevve.crud4.model.builders.user;

import com.maltsevve.crud4.model.User;

public class UserDirector {
    UserBuilder userBuilder;

    public void setUserBuilder(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    public User buildUser() {
        userBuilder.buildUser();
        userBuilder.buildFirstName();
        userBuilder.buildLastName();
        userBuilder.buildPosts();
        userBuilder.buildRegion();
        userBuilder.buildRole();
        return userBuilder.getUser();
    }
}
