package com.example.loginandpassvord.userRepository;

import com.example.loginandpassvord.authoritiesModel.Authorities;
import com.example.loginandpassvord.authoritiesModel.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {
    private List<User> users = new CopyOnWriteArrayList<>(new User[]{
            new User("Step", "12345", new ArrayList<>(List.of(new Authorities[]{Authorities.WRITE}))),
            });
    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User singleUser : users) {
            if (singleUser.getName().equals(user) && singleUser.getPassword().equals(password)) {
                return singleUser.getAuthorities();
            }
        }
        return new ArrayList<>();
    }
}