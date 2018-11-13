package com.ttuleja.bulletinboard.Service;

import com.ttuleja.bulletinboard.Dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public void deleteItem(String id) {
        this.adminDao.deleteItem(id);
    }

    public void deleteComment(String id) {
        this.adminDao.deleteComment(id);
    }
}
