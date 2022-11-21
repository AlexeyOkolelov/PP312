package com.pp312.springboot_312.servise;


import com.pp312.springboot_312.model.User;

import java.util.List;

public interface UserServise {

    List<User> getAllUser();

    void add(User user);

    User getUser(Long id);

    void deleteUser(Long id);



}
