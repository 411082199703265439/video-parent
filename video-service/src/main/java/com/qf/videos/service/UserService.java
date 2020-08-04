package com.qf.videos.service;

import com.qf.videos.pojo.User;

public interface UserService {
    User selectUserByEmailAndPassword(User user);

    User selectUserByEmail(String email);

    Boolean insertUser(User user);

    Boolean updateUser(User user);
}
