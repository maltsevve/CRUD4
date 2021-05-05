package com.maltsevve.crud4.view;

import com.maltsevve.crud4.controller.PostController;
import com.maltsevve.crud4.model.Post;
import com.maltsevve.crud4.model.builders.post.ActualPostBuilder;
import com.maltsevve.crud4.model.builders.post.PostDirector;

import java.util.List;

import static com.maltsevve.crud4.view.Console.start;

public class PostView {
    private final PostController postController = new PostController();
    private final PostDirector postDirector = new PostDirector();

    private void postMenu() {
        System.out.println("'POSTS'\n" +
                "Select menu item:\n" +
                "1 - Save\n" +
                "2 - Update\n" +
                "3 - Get by ID\n" +
                "4 - Get all\n" +
                "5 - Delete\n" +
                "6 - Return");
    }

    public void logic() {
        System.out.println();
        postMenu();
        String input = ClientInput.getScanner().nextLine();

        if (input.matches("\\d+")) {
            switch (Integer.parseInt(input)) {
                case 1 -> { // SAVE
                    System.out.println("Input content: ");
                    input = ClientInput.getScanner().nextLine();

                    postDirector.setPostBuilder(new ActualPostBuilder(input));
                    postController.save(postDirector.buildPost());
                    System.out.println();

                    logic();
                }

                case 2 -> { // UPDATE
                    System.out.println("Input id and a new content: 'id=content'");
                    String[] strs = ClientInput.getScanner().nextLine().split("=");

                    if (strs.length == 2) {

                        Long id = Long.parseLong(strs[0]);
                        Post post = postController.getById(id);

                        if (post != null) {
                            if (!post.getContent().equals(strs[1])) {
                                postDirector.setPostBuilder(new ActualPostBuilder(strs[1]));
                                post = postDirector.buildPost();
                                post.setId(id);

                                postController.update(post);

                            } else {
                                System.out.println("The entered content is identical to the existing one.");
                            }
                        } else {
                            System.out.println("No post with specified ID in the data base.");
                        }
                    } else {
                        System.out.println("Invalid input format.");
                    }

                    System.out.println();
                    logic();
                }

                case 3 -> { // GET BY ID
                    System.out.println("Input region id: ");
                    input = ClientInput.getScanner().nextLine();

                    System.out.println();

                    if (input.matches("\\d+")) {
                        Post post = postController.getById(Long.parseLong(input));

                        if (post != null) {
                            System.out.println(post.getId() + " Content: " + post.getContent() + "\n");
                        } else {
                            System.out.println("No such post in the data base.\n");
                        }
                    } else {
                        System.out.println("Invalid ID.\n");
                    }

                    logic();
                }

                case 4 -> { // GET ALL
                    System.out.println();

                    List<Post> postList = postController.getAll();

                    if (!postList.isEmpty()) {
                        postList.forEach((p) -> System.out.println(p.getId() + " Content: " + p.getContent()));
                        System.out.println();
                    } else {
                        System.out.println("Table is empty.\n");
                    }

                    logic();
                }

                case 5 -> { // DELETE BY ID
                    System.out.println("Input post id: ");
                    input = ClientInput.getScanner().nextLine();

                    if (input.matches("\\d+")) {
                        Long id = Long.parseLong(input);
                        Post post;

                        if (id > 0 && (post = postController.getById(id)) != null) {
                            postController.deleteById(id);
                            System.out.println("Post with id " + post.getId() + " and content: " + post.getContent()
                                    + " deleted from table.");
                        }
                    } else {
                        System.out.println("Invalid ID.");
                    }

                    System.out.println();

                    logic();
                }

                case 6 -> { // Return to main menu
                    System.out.println();
                    start();
                }

                default -> { // Invalid input
                    System.out.println("Non-existent menu item. Try again.\n");
                    logic();
                }
            }
        } else {
            System.out.println("Use digits from 1 to 6.\n");
            logic();
        }
    }
}
