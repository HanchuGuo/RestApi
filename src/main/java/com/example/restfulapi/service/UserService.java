package com.example.restfulapi.service;

import com.example.restfulapi.dao.Userdao;
import com.example.restfulapi.entity.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    Userdao userdao;
    public boolean save(int id, Use u) {
        return userdao.save(id, u);
    }
    public boolean delete(int id) {
        return userdao.delete(id);
    }
    public Use get(int id) {
        return userdao.get(id);
    }
    public boolean update(int id, Use u) {
        return userdao.update(id, u);
    }
    public boolean patch(int id, String name) {
        return userdao.patch(id, name);
    }
}
