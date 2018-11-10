package com.ttuleja.bulletinboard.Service;

import com.ttuleja.bulletinboard.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
