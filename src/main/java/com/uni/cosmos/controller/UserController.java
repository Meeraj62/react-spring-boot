package com.uni.cosmos.controller;

import com.uni.cosmos.dao.UserDao;
import com.uni.cosmos.model.ResponseHandler;
import com.uni.cosmos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<User> users = this.userDao.findAll();
        return ResponseHandler.generateResponse("Users Fetched Successfully...", HttpStatus.OK, users);
    }

    @PostMapping("/store")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        this.userDao.save(user);
        return ResponseHandler.generateResponse("User Created Successfully...", HttpStatus.OK, user);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Object> editUser(@PathVariable("id") Long id) {
        User user = this.userDao.findById(id).orElseThrow(() -> new RuntimeException("User NOT FOUND for id: " + id));
        return ResponseHandler.generateResponse("User Edit Form...", HttpStatus.OK, user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Long id, @RequestBody User user) {

        return this.userDao.findById(id).map(oldUser -> {
                    oldUser.setFirstName(user.getFirstName());
                    oldUser.setLastName(user.getLastName());
                    oldUser.setEmail(user.getEmail());
                    oldUser.setUsername(user.getUsername());
                    oldUser.setPassword(user.getPassword());

                    this.userDao.save(oldUser);
                    return ResponseHandler.generateResponse("User Updated Successfully...", HttpStatus.OK, oldUser);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    this.userDao.save(user);
                    return ResponseHandler.generateResponse("User Created Successfully...", HttpStatus.OK, user);
                });
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> destroy(@PathVariable("id") Long id){
        User user = this.userDao.findById(id).orElseThrow( () -> new RuntimeException("User NOT FOUND for id: " + id));

        this.userDao.delete(user);

        return ResponseHandler.generateResponse("User Deleted Successfully...", HttpStatus.OK, user);
    }


}
