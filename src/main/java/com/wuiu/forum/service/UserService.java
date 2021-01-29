package com.wuiu.forum.service;

import com.wuiu.forum.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    Integer save(User user);

    User queryByToken(String token);
}
