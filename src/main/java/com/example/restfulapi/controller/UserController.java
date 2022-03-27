package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Use;
import com.example.restfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService us;

    @RequestMapping(value = "/save/{uid}/{name}/{age}", method = RequestMethod.POST)
    public ResponseEntity<String> save(@PathVariable("uid") int id, @PathVariable("name") String name, @PathVariable("age") int age) {
        Use u = new Use();
        u.setName(name);
        u.setAge(age);
        boolean res = us.save(id, u);
        return new ResponseEntity(new String("success"), HttpStatus.OK);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam int id) {
        boolean res = us.delete(id);
        return res;
    }
    @RequestMapping(value = "/get")
    public Use get(@RequestParam int id) {
        return us.get(id);
    }
    @RequestMapping(value = "/update")
    public void update(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
        Use u = new Use();
        u.setAge(age);
        u.setName(name);
        us.update(id, u);
    }
    @RequestMapping(value = "/patch")
    public void patch(@RequestParam int id, @RequestParam String name) {
        us.patch(id, name);
    }
}
