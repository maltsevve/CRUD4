//package com.maltsevve.crud4.repository;
//
//import com.maltsevve.crud4.model.Post;
//import com.maltsevve.crud4.model.Role;
//import com.maltsevve.crud4.model.User;
//import com.maltsevve.crud4.model.builders.post.ActualPostBuilder;
//import com.maltsevve.crud4.model.builders.user.ActualUserBuilder;
//import com.maltsevve.crud4.model.builders.user.UserDirector;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.maltsevve.crud4.repository.JavaIOPostRepositoryImpl.POST_DIRECTOR;
//
//public class JavaIOUserRepositoryImpl implements UserRepository {
//    private final static Connection CONNECTION = DataBaseConnector.getDataBaseConnector().getConnection();
//    private final static UserDirector USER_DIRECTOR = new UserDirector();
//
//    JavaIORegionRepositoryImpl jrr = new JavaIORegionRepositoryImpl();
//
//    public JavaIOUserRepositoryImpl() {
//
//    }
//
//    @Override
//    public User save(User user) {
//        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO users" +
//                "(FirstName, LastName, RegionID, Role) VALUES (?, ?, ?, ?)")) {
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());
//            preparedStatement.setLong(3, user.getRegion().getId());
//            preparedStatement.setString(4, String.valueOf(user.getRole()));
//            preparedStatement.executeUpdate();
//
//            jrr.save(user.getRegion());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return user;
//    }
//
//    @Override
//    public User update(User user) {
//        List<User> users = getAll(); // Нельзя в случае с hibernate переопределять id в equals и hashcode!!!
//        User user1 = users.stream().filter((u) -> u.getId().equals(user.getId())).findFirst().orElse(null);
//
//        if (user1 == null) {
//            System.out.println("Update is unavailable: no such ID in the data base.");
//            return user;
//        } else {
//            try (PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE users " +
//                    "SET FirstName = ?, LastName = ?, RegionID = ?, Role = ? " +
//                    "WHERE UserID = ?")) {
//                preparedStatement.setString(1, user.getFirstName());
//                preparedStatement.setString(2, user.getLastName());
//                preparedStatement.setLong(3, user.getRegion().getId());
//                preparedStatement.setString(4, String.valueOf(user.getRole()));
//                preparedStatement.setLong(5, user.getId());
//                preparedStatement.executeUpdate();
//
//                jrr.save(user.getRegion());
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            return user1;
//        }
//    }
//
//    @Override
//    public User getById(Long aLong) {
//        User user = null;
//
//        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM users " +
//                "WHERE UserID = ?")) {
//            preparedStatement.setLong(1, aLong);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                USER_DIRECTOR.setUserBuilder(new ActualUserBuilder(resultSet.getString("FirstName"),
//                        resultSet.getString("LastName"), getUserPosts(aLong),
//                        jrr.getById(resultSet.getLong("RegionID")),
//                        Role.valueOf(resultSet.getString("Role"))));
//                user = USER_DIRECTOR.buildUser();
//                user.setId(resultSet.getLong("UserID"));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return user;
//    }
//
//    @Override
//    public List<User> getAll() {
//        List<User> users = new ArrayList<>();
//
//        try (Statement statement = CONNECTION.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("""
//                    SELECT *
//                    FROM users
//                    """);
//            while (resultSet.next()) {
//                USER_DIRECTOR.setUserBuilder(new ActualUserBuilder(resultSet.getString("FirstName"),
//                        resultSet.getString("LastName"), getUserPosts(resultSet.getLong("UserID")),
//                        jrr.getById(resultSet.getLong("RegionID")),
//                        Role.valueOf(resultSet.getString("Role"))));
//                User user = USER_DIRECTOR.buildUser();
//                user.setId(resultSet.getLong("UserID"));
//                users.add(user);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return users.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement("DELETE FROM users " +
//                "WHERE UserID = ?")) {
//            preparedStatement.setLong(1, aLong);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    private List<Post> getUserPosts(Long userId) {
//        List<Post> posts = new ArrayList<>();
//
//        try (PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM posts " +
//                "WHERE UserID = ?")) {
//            preparedStatement.setLong(1, userId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                POST_DIRECTOR.setPostBuilder(new ActualPostBuilder(resultSet.getString("Content")));
//                Post post = POST_DIRECTOR.buildPost();
//                post.setId(resultSet.getLong("PostID"));
//                post.setCreated(resultSet.getTimestamp("Created"));
//                post.setUpdated(resultSet.getTimestamp("Updated"));
//                posts.add(post);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return posts.stream().sorted(Comparator.comparing(Post::getId)).collect(Collectors.toList());
//    }
//}
