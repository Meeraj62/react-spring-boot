package com.uni.cosmos.dao;

import com.uni.cosmos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
