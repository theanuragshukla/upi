package com.anurag.upi.dao;

import com.anurag.upi.Entities.UsersEntity;
import com.anurag.upi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class PostgresDao implements UsersDao {

    private final UserRepository db;

    public PostgresDao(@Autowired UserRepository userRepository) {
        db = userRepository;
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return db.findAll();
    }

    @Override
    public void addNewUser(UsersEntity user) {
        db.save(user);
    }

  @Override
    public UsersEntity updateUserAccount(boolean accountStatus, String userid){
        UsersEntity user = db.findByUserid(userid);
        if(user!=null){
            user.setAccount(true);
            db.save(user);
            return user;
        }else{
            return null;
        }
  }

    @Override
    public void deleteUser(String userid) {
        db.deleteAllByUserid(userid);
    }
}
