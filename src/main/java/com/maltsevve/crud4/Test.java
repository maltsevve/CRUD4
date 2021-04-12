package com.maltsevve.crud4;

import com.maltsevve.crud4.model.Post;
import com.maltsevve.crud4.model.Region;
import com.maltsevve.crud4.model.Role;
import com.maltsevve.crud4.model.User;
import com.maltsevve.crud4.repository.JavaIORegionRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        JavaIORegionRepositoryImpl rr = new JavaIORegionRepositoryImpl();

//        Region region = new Region();
//        region.setName("Tashkent");
//        region.setId(1L);
//        rr.update(region);

        rr.getAll().forEach(System.out::println);

//        Post post = new Post();
//        post.setContent("Tolko ne v Rostov!!!");
//        post.setCreated(new Date());
//
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(post);
//
//        User user = new User();
//        user.setFirstName("Oleg");
//        user.setLastName("NoguZadirishsenko");
//        user.setRegion(region);
//        user.setRole(Role.USER);
//        user.setPosts(posts);
    }
}
