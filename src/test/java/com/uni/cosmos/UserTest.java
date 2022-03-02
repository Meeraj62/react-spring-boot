package com.uni.cosmos;

import com.uni.cosmos.dao.UserDao;
import com.uni.cosmos.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testSaveUser() {
        User user = new User(1L, "John", "Doe", "john.doe@email.com", "johhny", "strong-password");

        this.userDao.save(user);

        userDao.findById(1L).map(
                newUser -> {
                    Assertions.assertEquals("john", newUser.getFirstName());
                    return true;
                });
    }

    @Test
    public void getUser(){
        User user = new User(2L,"John","Doe","john.doe@email.com","johhny","strong-password");
        User user2 = new User(3L,"Daniel","Marcus","daniel@daniel.com","danie","super_strong_password");
        userDao.save(user);

        userDao.save(user2);

        userDao.findById(1L)
                .map(newUser ->{
                    Assertions.assertEquals("danie",newUser.getUsername());
                    return true;
                });

    }

    @Test
    public void getUsers(){
        User user = new User(1L,"John","Doe","john.doe@email.com","johhny","strong-password");
        User user2 = new User(2L,"Daniel","Marcus","daniel@daniel.com","danie","super_strong_password");
        userDao.save(user);
        userDao.save(user2);

        Assertions.assertNotNull(userDao.findAll());
    }

    @Test
    public void deleteUser(){
        User user = new User(1L,"John","Doe","john.doe@email.com","johhny","strong-password");
        userDao.save(user);
        userDao.delete(user);
        Assertions.assertTrue(userDao.findAll().isEmpty());
    }
}
