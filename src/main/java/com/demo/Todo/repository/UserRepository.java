package com.demo.Todo.repository;

import com.demo.Todo.entity.User;

public interface UserRepository {
    User findByUsernameAndPassword(String username,String password);
    User findTopByUsername(String username);
    User findTopByPassword(String password);
}
