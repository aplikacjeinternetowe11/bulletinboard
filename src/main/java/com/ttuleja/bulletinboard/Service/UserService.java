package com.ttuleja.bulletinboard.Service;

import com.ttuleja.bulletinboard.Dao.UserDao;
import com.ttuleja.bulletinboard.Entity.Comment;
import com.ttuleja.bulletinboard.Entity.Item;
import com.ttuleja.bulletinboard.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void addUser(String username, String password, String phone_number) {
        userDao.addUser(username,encode(password),phone_number);
    }

    public static String encode(String password){
        int i = 0;
        String hashedPassword = "";
        while (i<10){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(password);
            i++;
        }
        return hashedPassword;
    }

    public String getUserPhoneNumberByItemId(int id) {
        return this.userDao.getUserPhoneNumberByItemId(id);
    }

    public User getUserDetails(String userName) {
        return this.userDao.getUserDetails(userName);
    }

    public Collection<Item> getUserItems(String userName) {
        return this.userDao.getUserItems(userName);
    }

    public Collection<Comment> getUserComments(String userName) {
        return this.userDao.getUserComments(userName);
    }

    public boolean checkUserName(String username) {
        return this.userDao.checkUserName(username);
    }
}
