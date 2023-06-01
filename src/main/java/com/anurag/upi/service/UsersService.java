package com.anurag.upi.service;

import com.anurag.upi.Entities.UsersEntity;
import com.anurag.upi.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersDao usersDao;
    @Autowired
    public UsersService(@Qualifier("postgres") UsersDao usersDao) {
        this.usersDao = usersDao;
    }



    public List<UsersEntity> getAllUsers(){
        return usersDao.getAllUsers();
    }
    public void addNewUser(UsersEntity user){
        usersDao.addNewUser(user);
    }
    public UsersEntity updateUserAccount(boolean status , String id){
        return usersDao.updateUserAccount(status, id);
    }
    public void deleteUser(String id){
        usersDao.deleteUser(id);
    }
}
