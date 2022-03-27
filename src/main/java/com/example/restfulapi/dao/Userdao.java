package com.example.restfulapi.dao;

import com.example.restfulapi.entity.Use;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Userdao {
       Map<Integer, Use> map = new HashMap<>();
       public synchronized boolean save(int id, Use use) {
              map.put(id, use);
              return true;
       }
       public synchronized boolean delete(int id) {
              if (map.containsKey(id)) {
                     map.remove(id);
                     return true;
              }
              return false;
       }
       public synchronized Use get(int id) {
              Use u = map.get(id);
              return u;
       }
       public synchronized boolean update(int id, Use u) {
              map.put(id, u);
              return true;
       }
       public synchronized boolean patch(int id, String name) {
              Use u = map.get(id);
              u.setName(name);
              return true;
       }
}
