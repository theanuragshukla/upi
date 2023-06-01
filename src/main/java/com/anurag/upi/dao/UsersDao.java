package com.anurag.upi.dao;


import com.anurag.upi.Entities.UsersEntity;

import java.util.List;

public interface UsersDao {
    List<UsersEntity> getAllUsers();
     void addNewUser(UsersEntity user);

    UsersEntity updateUserAccount(boolean accountStatus, String userid);

    void deleteUser(String userid);
}
